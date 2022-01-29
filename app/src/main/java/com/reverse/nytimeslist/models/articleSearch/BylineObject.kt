package com.reverse.nytimeslist.models.articleSearch

import com.google.gson.annotations.SerializedName

data class BylineObject(

    @field:SerializedName("original")
    val original: String? = null,

    @field:SerializedName("person")
    val person: ArrayList<PersonItem>? = null,

    @field:SerializedName("organization")
    val org: String? = null,
)
