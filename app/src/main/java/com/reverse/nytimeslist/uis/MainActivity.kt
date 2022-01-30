package com.reverse.nytimeslist.uis

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import com.reverse.nytimeslist.R
import com.reverse.nytimeslist.api.ApiConstants
import com.reverse.nytimeslist.api.ApiServices
import com.reverse.nytimeslist.api.NYTimesAPI
import com.reverse.nytimeslist.models.ListModel
import com.reverse.nytimeslist.models.mostPopular.MostPopularResponse
import io.paperdb.Paper
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var apiClient: ApiServices? = null
    var pd: Dialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        apiClient = NYTimesAPI.client.create(ApiServices::class.java)

        tv_search_articles.setOnClickListener(this)
        tv_most_emailed.setOnClickListener(this)
        tv_most_shared.setOnClickListener(this)
        tv_most_viewed.setOnClickListener(this)
    }

    fun showProgressDialog() {
        pd?.dismiss()
        pd = Dialog(this)
        pd?.setContentView(R.layout.dialog_custom_progress)
        pd?.setCancelable(false)
        val window = pd?.window
        if (window != null) {
            window.setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT)
            window.setGravity(Gravity.CENTER)
            window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
        pd?.show()
    }

    fun hideProgressDialog() {
        pd?.dismiss()
    }

    override fun onClick(v: View?) {
        when (v) {
            tv_search_articles -> {
                startActivity(Intent(this, ArticleSearchActivity::class.java))
            }
            tv_most_emailed -> {
                showProgressDialog()
                val call = apiClient?.mostEmailed(ApiConstants.apiKey)
                call?.enqueue(object : Callback<MostPopularResponse> {
                    override fun onResponse(
                        call: Call<MostPopularResponse>,
                        response: Response<MostPopularResponse>
                    ) {
                        hideProgressDialog()
                        val articles = response.body()!!.results!!
                        val list = ArrayList<ListModel>()
                        if (!articles.isNullOrEmpty()) {
                            for (i in articles.indices) {
                                list.add(
                                    ListModel(
                                        articles[i].title,
                                        articles[i].date,
                                        articles[i].url
                                    )
                                )
                            }
                        }
                        Paper.book().delete("LIST_MODEL")
                        Paper.book().write("LIST_MODEL", list)
                        startActivity(Intent(this@MainActivity, SearchResultActivity::class.java))
                    }

                    override fun onFailure(call: Call<MostPopularResponse>, t: Throwable) {
                        hideProgressDialog()
                        Toast.makeText(this@MainActivity, t.toString(), Toast.LENGTH_SHORT).show()
                    }
                })
            }
            tv_most_shared -> {
                showProgressDialog()
                val call = apiClient?.mostShared(ApiConstants.apiKey)
                call?.enqueue(object : Callback<MostPopularResponse> {
                    override fun onResponse(
                        call: Call<MostPopularResponse>,
                        response: Response<MostPopularResponse>
                    ) {
                        hideProgressDialog()
                        val articles = response.body()!!.results!!
                        val list = ArrayList<ListModel>()
                        if (!articles.isNullOrEmpty()) {
                            for (i in articles.indices) {
                                list.add(
                                    ListModel(
                                        articles[i].title,
                                        articles[i].date,
                                        articles[i].url
                                    )
                                )
                            }
                        }
                        Paper.book().delete("LIST_MODEL")
                        Paper.book().write("LIST_MODEL", list)
                        startActivity(Intent(this@MainActivity, SearchResultActivity::class.java))
                    }

                    override fun onFailure(call: Call<MostPopularResponse>, t: Throwable) {
                        hideProgressDialog()
                        Toast.makeText(this@MainActivity, t.toString(), Toast.LENGTH_SHORT).show()
                    }
                })
            }
            tv_most_viewed -> {
                showProgressDialog()
                val call = apiClient?.mostViewed(ApiConstants.apiKey)
                call?.enqueue(object : Callback<MostPopularResponse> {
                    override fun onResponse(
                        call: Call<MostPopularResponse>,
                        response: Response<MostPopularResponse>
                    ) {
                        hideProgressDialog()
                        val articles = response.body()!!.results!!
                        val list = ArrayList<ListModel>()
                        if (!articles.isNullOrEmpty()) {
                            for (i in articles.indices) {
                                list.add(
                                    ListModel(
                                        articles[i].title,
                                        articles[i].date,
                                        articles[i].url
                                    )
                                )
                            }
                        }
                        Paper.book().delete("LIST_MODEL")
                        Paper.book().write("LIST_MODEL", list)
                        startActivity(Intent(this@MainActivity, SearchResultActivity::class.java))
                    }

                    override fun onFailure(call: Call<MostPopularResponse>, t: Throwable) {
                        hideProgressDialog()
                        Toast.makeText(this@MainActivity, t.toString(), Toast.LENGTH_SHORT).show()
                    }
                })
            }
        }
    }
}