package com.mth.padc_flight_movie.data.vos

import com.google.gson.annotations.SerializedName

data class MovieDetailVO(
    @SerializedName("backdrop_path")
    var backdrop_path: String,
    @SerializedName("genres")
    var genres: List<GenreVO>,
    @SerializedName("id")
    var id: Int,
    @SerializedName("original_title")
    var original_title: String,
    @SerializedName("overview")
    var overview: String,
    @SerializedName("poster_path")
    var poster_path: String,
    @SerializedName("production_companies")
    var production_companies: List<ProductionCompanyVO>,
    @SerializedName("release_date")
    var release_date: String,
    @SerializedName("runtime")
    var runtime: Int,
    @SerializedName("vote_average")
    var vote_average: Double,
    @SerializedName("vote_count")
    var vote_count: Int,
    @SerializedName("production_countries")
    var production_countries: List<ProductionCountryVO>


    )