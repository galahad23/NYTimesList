package com.reverse.nytimeslist.models.articleSearch

import com.google.gson.annotations.SerializedName

data class ArticleSearchResponse(

    @field:SerializedName("status")
    val status: String? = null,

    @field:SerializedName("copyright")
    val copyright: String? = null,

    @field:SerializedName("response")
    val response: ResponseObject? = null
)
