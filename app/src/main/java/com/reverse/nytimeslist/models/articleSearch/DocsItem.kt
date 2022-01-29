package com.reverse.nytimeslist.models.articleSearch

import com.google.gson.annotations.SerializedName

data class DocsItem(

    @field:SerializedName("web_url")
    val webUrl: String? = null,

    @field:SerializedName("snippet")
    val snippet: String? = null,

    @field:SerializedName("print_page")
    val printPage: Int? = null,

    @field:SerializedName("source")
    val source: String? = null,

    @field:SerializedName("multimedia")
    val multimedia: ArrayList<MultimediaItem>? = null,

    @field:SerializedName("headline")
    val headline: HeadlineObject? = null,

    @field:SerializedName("keywords")
    val keywords: ArrayList<KeywordItem>? = null,

    @field:SerializedName("pub_date")
    val pubDate: String? = null,

    @field:SerializedName("document_type")
    val docType: String? = null,

    @field:SerializedName("news_desk")
    val newsDesk: String? = null,

    @field:SerializedName("byline")
    val byline: BylineObject? = null,

    @field:SerializedName("type_of_material")
    val typeOfMaterial: String? = null,

    @field:SerializedName("_id")
    val id: String? = null,

    @field:SerializedName("score")
    val score: Int? = null,

    @field:SerializedName("word_count")
    val wordCount: Int? = null,

    @field:SerializedName("uri")
    val uri: String? = null,
)
