package com.reverse.nytimeslist.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NYTimesAPI {

    companion object {

        private var retrofit: Retrofit? = null

        val client: Retrofit
            get() {
                if (retrofit == null) {
                    retrofit = Retrofit.Builder()
                        .addConverterFactory(GsonConverterFactory.create())
                        .baseUrl(ApiConstants.baseUrl)
                        .build()
                }
                return retrofit!!
            }
    }
}