package com.reverse.nytimeslist.models.mostPopular

import com.google.gson.annotations.SerializedName

data class MostPopularResponse(

    @field:SerializedName("status")
    val staus: String? = null,

    @field:SerializedName("copyright")
    val copyright: String? = null,

    @field:SerializedName("num_results")
    val numResults: Int? = null,

    @field:SerializedName("results")
    val results: ArrayList<ResultsItem>? = null
)
