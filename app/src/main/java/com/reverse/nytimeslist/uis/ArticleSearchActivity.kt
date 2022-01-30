package com.reverse.nytimeslist.uis

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.reverse.nytimeslist.AppUtil
import com.reverse.nytimeslist.R
import com.reverse.nytimeslist.api.ApiConstants
import com.reverse.nytimeslist.api.ApiServices
import com.reverse.nytimeslist.api.NYTimesAPI
import com.reverse.nytimeslist.models.ListModel
import com.reverse.nytimeslist.models.articleSearch.ArticleSearchResponse
import io.paperdb.Paper
import kotlinx.android.synthetic.main.activity_search.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ArticleSearchActivity: AppCompatActivity(), View.OnClickListener {

    private var apiClient: ApiServices? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        apiClient = NYTimesAPI.client.create(ApiServices::class.java)

        tv_search_button.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            tv_search_button -> {
                val query = et_search_query.text.toString()
                val call = apiClient?.searchArticles(query, ApiConstants.apiKey)

                call?.enqueue(object : Callback<ArticleSearchResponse> {
                    override fun onResponse(
                        call: Call<ArticleSearchResponse>,
                        response: Response<ArticleSearchResponse>
                    ) {
                        val articles = response.body()!!.response!!.docs!!
                        val list = ArrayList<ListModel>()
                        if (!articles.isNullOrEmpty()) {
                            for (i in articles.indices) {
                                list.add(
                                    ListModel(
                                        articles[i].headline!!.main,
                                        AppUtil.convertISODate(articles[i].pubDate!!),
                                        articles[i].webUrl
                                    )
                                )
                            }
                        }
                        Paper.book().delete("LIST_MODEL")
                        Paper.book().write("LIST_MODEL", list)
                        startActivity(Intent(this@ArticleSearchActivity, SearchResultActivity::class.java))
                    }

                    override fun onFailure(call: Call<ArticleSearchResponse>, t: Throwable) {
                        Toast.makeText(this@ArticleSearchActivity, t.toString(), Toast.LENGTH_SHORT).show()
                    }
                })
            }
        }
    }
}