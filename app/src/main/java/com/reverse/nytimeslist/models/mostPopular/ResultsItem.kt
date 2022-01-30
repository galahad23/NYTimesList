package com.reverse.nytimeslist.models.mostPopular

import com.google.gson.annotations.SerializedName

data class ResultsItem(

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("updated")
    val date: String? = null,

    @field:SerializedName("url")
    val url: String? = null
)
