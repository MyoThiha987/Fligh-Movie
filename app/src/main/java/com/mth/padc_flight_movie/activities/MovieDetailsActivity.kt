package com.mth.padc_flight_movie.activities

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.google.android.material.chip.ChipGroup
import com.mth.padc_flight_movie.R
import com.mth.padc_flight_movie.adapters.CrewAdapter
import com.mth.padc_flight_movie.adapters.NowPlayingMovieAdapter
import com.mth.padc_flight_movie.data.vos.CastAndCrewVO
import com.mth.padc_flight_movie.data.vos.MovieDetailVO
import com.mth.padc_flight_movie.mvp.presenters.MovieDetailPresenter
import com.mth.padc_flight_movie.mvp.presenters.impls.MovieDetailPresenterImpl
import com.mth.padc_flight_movie.mvp.views.MovieDetailView
import com.mth.padc_flight_movie.root.App.Companion.context
import com.mth.padc_flight_movie.utils.BASE_IMAGE_URL
import com.mth.padc_flight_movie.utils.createChip
import com.mth.padc_flight_movie.utils.dateFormat
import com.mth.padc_flight_movie.utils.toHourAndMinute
import com.mth.padc_flight_movie.views.viewpods.DescriptionViewPod
import com.mth.padc_flight_movie.views.viewpods.NowPlayingMovieViewPod
import com.parassidhu.simpledate.toDateStandard
import kotlinx.android.synthetic.main.activity_movie_details.*
import kotlinx.android.synthetic.main.activity_movie_details.imv_cover

class MovieDetailsActivity : AppCompatActivity(), MovieDetailView {

    private lateinit var mMovieDetailPrsenter: MovieDetailPresenter
    private lateinit var mTopRateMovieAdapter: NowPlayingMovieAdapter
    private lateinit var mCrewAdapter : CrewAdapter
    private lateinit var mDescriptionViewPod : DescriptionViewPod
    private lateinit var mDelegate : NowPlayingMovieViewPod.Delegate

    companion object {
        const val MOVIE_ID_EXTRA = "Movie Id Extra"
        fun newIntent(context: Context, id: Int): Intent {
            val intent = Intent(context, MovieDetailsActivity::class.java)
            intent.putExtra(MOVIE_ID_EXTRA, id)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
        setUpPresenter()
        setUpActorsRecycler()
        setUpCreatorsRecycler()
        onBackPress()
        mMovieDetailPrsenter.onUIReady(this, intent.getIntExtra(MOVIE_ID_EXTRA, 0))
    }

    private fun setUpActorsRecycler() {
        mTopRateMovieAdapter = NowPlayingMovieAdapter(mMovieDetailPrsenter)
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvActors.layoutManager = linearLayoutManager
        rvActors.adapter = mTopRateMovieAdapter
    }

    private fun setUpCreatorsRecycler(){
        mCrewAdapter = CrewAdapter(mMovieDetailPrsenter)
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCreators.layoutManager = linearLayoutManager
        rvCreators.adapter = mCrewAdapter
    }

    private fun setUpPresenter() {
        mMovieDetailPrsenter = ViewModelProviders.of(this).get(MovieDetailPresenterImpl::class.java)
        mMovieDetailPrsenter.initPresenter(this)
    }

    override fun showMovieDetailbyId(movie: MovieDetailVO) {
        bindDataToUi(movie)
        setUpViewPod(movie)
    }

    override fun showMovieDetailByCastAndCrew(cast: CastAndCrewVO) {
        mTopRateMovieAdapter.setNewData(cast.cast.toMutableList())
        mCrewAdapter.setNewData(cast.crew.toMutableList())
    }

    private fun setUpViewPod(movie: MovieDetailVO){
        mDescriptionViewPod = descViewPod as DescriptionViewPod
        mDescriptionViewPod.bindData(movie)
    }

    private fun bindChip(chipGroup: ChipGroup,movieDetail : MovieDetailVO){

        for (genre in movieDetail.genres.indices) {
            val chips = chipGroup.context.createChip(movieDetail.genres[genre].name!!)
            chipGroup.addView(chips)
        }

    }

    @SuppressLint("SimpleDateFormat")
    private fun bindDataToUi(movie: MovieDetailVO) {
        Glide.with(context)
            .load(BASE_IMAGE_URL + movie.backdrop_path)
            .into(imv_cover)

        movie.apply {

            tv_year.text = release_date.dateFormat(release_date).toDateStandard()
            tv_vote_count.text = vote_count.toString()
            tv_vote_average.text = vote_average.toString()
            tv_movie_name.text = original_title
            tv_duration.text = runtime.toHourAndMinute(runtime)
            bindChip(chipGroup,this)
            tv_storyline_desc.text = overview
        }
    }

    private fun onBackPress(){
        imvBack.setOnClickListener {
            onBackPressed()
        }
    }
}