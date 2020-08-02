package com.mth.padc_flight_movie.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.mth.padc_flight_movie.R
import com.mth.padc_flight_movie.mvp.presenters.impls.YouTubePlayerPresenterImpl
import com.mth.padc_flight_movie.mvp.views.YouTubePlayerView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import kotlinx.android.synthetic.main.activity_you_tube_player.*


class YouTubePlayerActivity : AppCompatActivity() ,YouTubePlayerView {

    private lateinit var youTubePlayerView: com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

    private lateinit var mYoutubePlayerPresenter : YouTubePlayerPresenterImpl

    companion object{
        const val MOVIE_ID ="movieID"
        fun newIntent(context: Context,id:Int): Intent {
            val intent = Intent(context,YouTubePlayerActivity::class.java)
            intent.putExtra(MOVIE_ID,id)
            return intent
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_you_tube_player)
        setUpPresenter()
        setUpYoutubePlayerView()
        mYoutubePlayerPresenter.onUIReady(this,intent.getIntExtra(MOVIE_ID,0))

    }

    private fun setUpPresenter() {
        mYoutubePlayerPresenter = ViewModelProviders.of(this).get(YouTubePlayerPresenterImpl::class.java)
        mYoutubePlayerPresenter.initPresenter(this)
    }

    private fun setUpYoutubePlayerView(){
        youTubePlayerView = youtube_player_view as com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
        lifecycle.addObserver(youTubePlayerView)
    }

    override fun playMovie(data: String) {
        youtube_player_view.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(@NonNull youTubePlayer: YouTubePlayer) {
                youTubePlayer.loadVideo(data,0f)
            }
            override fun onError(youTubePlayer: YouTubePlayer, error: PlayerConstants.PlayerError) {
                super.onError(youTubePlayer, error)
            }
        })
    }
}