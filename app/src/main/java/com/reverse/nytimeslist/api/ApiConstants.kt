package com.reverse.nytimeslist.api

class ApiConstants {

    companion object {
        const val baseUrl = "https://api.nytimes.com/svc/"
        const val apiKey = "UQBr4MyQMScefYPSimr3tKS2s9p2PBda"

        const val articleSearch = "search/v2/articlesearch.json?"
        const val mostViewed = "mostpopular/v2/viewed/1.json?"
        const val mostEmailed = "mostpopular/v2/emailed/1.json?"
        const val mostShared = "mostpopular/v2/shared/1.json?"
    }
}