package com.mth.padc_flight_movie.network

import com.mth.padc_flight_movie.BuildConfig
import com.mth.padc_flight_movie.data.vos.CastAndCrewVO
import com.mth.padc_flight_movie.data.vos.CastCrewVO
import com.mth.padc_flight_movie.data.vos.MovieDetailVO
import com.mth.padc_flight_movie.network.responses.MovieGenreResponse
import com.mth.padc_flight_movie.network.responses.MovieListResponse
import com.mth.padc_flight_movie.network.responses.VideoResponse
import com.mth.padc_flight_movie.utils.*
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {

    @GET("$GET_MOVIE_DETAIL{movie_id}")
    fun getMovieDetails(
        @Path("movie_id") movieId : Int,
        @Query("api_key") apiKey : String = BuildConfig.API_KEY
    ) : Observable<MovieDetailVO>

    @GET("$GET_MOVIE_DETAIL{movie_id}/{casts}")
    fun getMovieDetailsByCastAndCrew(
        @Path("movie_id") movieId : Int,
        @Path("casts") casts : String ="casts",
        @Query("api_key") apiKey : String = BuildConfig.API_KEY
    ) : Observable<CastAndCrewVO>

    @GET(GET_POPULAR_MOVIE)
    fun getPopularMovies(
        @Query("api_key") apiKey : String = BuildConfig.API_KEY
    ) : Observable<MovieListResponse>

    @GET(GET_MOVIE_GENRES)
    fun getMovieGenre(
        @Query("api_key") apiKey : String = BuildConfig.API_KEY
    ) : Observable<MovieGenreResponse>

    @GET(GET_TOP_RATE_MOVIE)
    fun getTopRateMovie(
        @Query("api_key") apiKey : String = BuildConfig.API_KEY
    ) : Observable<MovieListResponse>

    @GET(GET_DISCOVER_MOVIE)
    fun getDiscoverMovieByGenreId(
        @Query("api_key") apiKey : String = BuildConfig.API_KEY,
        @Query("with_genres") genreId : Int
    ):Observable<MovieListResponse>

    @GET("$GET_MOVIE_DETAIL{movie_id}/videos")
    fun getMoviesById(
        @Path("movie_id")  movieId : Int,
        @Query("api_key") apiKey : String = BuildConfig.API_KEY
    ):Observable<VideoResponse>
}