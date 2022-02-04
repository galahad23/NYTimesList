package com.reverse.nytimeslist

import com.reverse.nytimeslist.api.ApiConstants
import com.reverse.nytimeslist.api.ApiServices
import com.reverse.nytimeslist.api.NYTimesAPI
import org.junit.Test
import strikt.api.expectThat

class ApiResponseTest {

    private var apiClient: ApiServices? = null

    @Test
    fun `can get search list` () {
        // call the api
        apiClient = NYTimesAPI.client.create(ApiServices::class.java)
        val searchQuery = "search"
        val call = apiClient?.searchArticles(searchQuery, ApiConstants.apiKey)

        expectThat(call?.request()) {
            assertThat("is GET method") {
                it?.method() == "GET"
            }
            assertThat("has given search query") {
                it?.url()?.queryParameterValues("search") == listOf(searchQuery)
            }
        }
    }
}