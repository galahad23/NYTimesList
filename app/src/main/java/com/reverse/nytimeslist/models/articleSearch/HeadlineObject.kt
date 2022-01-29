package com.reverse.nytimeslist.models.articleSearch

import com.google.gson.annotations.SerializedName

data class HeadlineObject(

    @field:SerializedName("main")
    val main: String? = null,

    @field:SerializedName("kicker")
    val kicker: String? = null,

    @field:SerializedName("content_kicker")
    val contentKicker: String? = null,

    @field:SerializedName("print_headline")
    val printHeadline: String? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("seo")
    val seo: String? = null,

    @field:SerializedName("sub")
    val sub: String? = null,
)
