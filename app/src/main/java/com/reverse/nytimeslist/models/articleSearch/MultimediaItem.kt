package com.reverse.nytimeslist.models.articleSearch

import com.google.gson.annotations.SerializedName

data class MultimediaItem(

    @field:SerializedName("rank")
    val rank: Int? = null,

    @field:SerializedName("subtype")
    val subType: String? = null,

    @field:SerializedName("caption")
    val caption: String? = null,

    @field:SerializedName("credit")
    val credit: String? = null,

    @field:SerializedName("type")
    val type: String? = null,

    @field:SerializedName("url")
    val url: String? = null,

    @field:SerializedName("height")
    val height: Int? = null,

    @field:SerializedName("width")
    val width: Int? = null,

    @field:SerializedName("legacy")
    val legacy: LegacyObject? = null,

    @field:SerializedName("crop_name")
    val cropName: String? = null,
)
