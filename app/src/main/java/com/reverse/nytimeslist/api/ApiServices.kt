package com.reverse.nytimeslist.api

import com.reverse.nytimeslist.models.articleSearch.ArticleSearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {

    @GET(ApiConstants.articleSearch)
    fun searchArticles(
        @Query("q") q: String,
        @Query("api-key") apiKey: String
    ): Call<ArticleSearchResponse>
}