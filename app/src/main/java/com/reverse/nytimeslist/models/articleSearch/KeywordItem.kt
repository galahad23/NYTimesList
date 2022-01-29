package com.reverse.nytimeslist.models.articleSearch

import com.google.gson.annotations.SerializedName

data class KeywordItem(

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("value")
    val value: String? = null,

    @field:SerializedName("rank")
    val rank: Int? = null,

    @field:SerializedName("major")
    val major: String? = null

)
