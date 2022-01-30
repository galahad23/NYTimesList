package com.reverse.nytimeslist.api

import com.reverse.nytimeslist.models.articleSearch.ArticleSearchResponse
import com.reverse.nytimeslist.models.mostPopular.MostPopularResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {

    @GET(ApiConstants.articleSearch)
    fun searchArticles(
        @Query("q") q: String,
        @Query("api-key") apiKey: String
    ): Call<ArticleSearchResponse>

    @GET(ApiConstants.mostEmailed)
    fun mostEmailed(
        @Query("api-key") apiKey: String
    ): Call<MostPopularResponse>

    @GET(ApiConstants.mostShared)
    fun mostShared(
        @Query("api-key") apiKey: String
    ): Call<MostPopularResponse>

    @GET(ApiConstants.mostViewed)
    fun mostViewed(
        @Query("api-key") apiKey: String
    ): Call<MostPopularResponse>
}