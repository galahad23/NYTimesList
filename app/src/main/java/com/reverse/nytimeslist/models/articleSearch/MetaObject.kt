package com.reverse.nytimeslist.models.articleSearch

import com.google.gson.annotations.SerializedName

data class MetaObject(

    @field:SerializedName("hits")
    val hits: Int? = null,

    @field:SerializedName("offset")
    val offset: Int? = null,

    @field:SerializedName("time")
    val time: Int? = null
)
