package com.reverse.nytimeslist.models.articleSearch

import com.google.gson.annotations.SerializedName

data class ResponseObject(

    @field:SerializedName("docs")
    val docs: ArrayList<DocsItem>? = null,

    @field:SerializedName("meta")
    val meta: MetaObject? = null
)
