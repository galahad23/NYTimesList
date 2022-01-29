package com.reverse.nytimeslist.models.articleSearch

import com.google.gson.annotations.SerializedName

data class LegacyObject(

    @field:SerializedName("xlarge")
    val xLarge: String? = null,

    @field:SerializedName("xlargewidth")
    val xLargeWidth: Int? = null,

    @field:SerializedName("xlargeheight")
    val xLargeHeight: Int? = null,
)
