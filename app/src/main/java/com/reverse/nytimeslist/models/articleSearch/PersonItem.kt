package com.reverse.nytimeslist.models.articleSearch

import com.google.gson.annotations.SerializedName

data class PersonItem(

    @field:SerializedName("firstname")
    val firstName: String? = null,

    @field:SerializedName("middlename")
    val middleName: String? = null,

    @field:SerializedName("lastname")
    val lastName: String? = null,

    @field:SerializedName("qualifier")
    val qualifier: String? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("role")
    val role: String? = null,

    @field:SerializedName("organization")
    val org: String? = null,

    @field:SerializedName("rank")
    val rank: Int? = null,
)
