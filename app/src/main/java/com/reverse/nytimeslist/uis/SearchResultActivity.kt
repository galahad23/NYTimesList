package com.reverse.nytimeslist.uis

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.reverse.nytimeslist.R
import com.reverse.nytimeslist.adapters.ArticleAdapter
import com.reverse.nytimeslist.listeners.ArticleListener
import com.reverse.nytimeslist.models.ListModel
import io.paperdb.Paper
import kotlinx.android.synthetic.main.activity_search_result.*

class SearchResultActivity: AppCompatActivity(), ArticleListener {

    lateinit var list: ArrayList<ListModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_result)

        if (!Paper.book().read<ArrayList<ListModel>>("LIST_MODEL").isNullOrEmpty()) {
            rv_search_results.visibility = View.VISIBLE
            tv_no_results.visibility = View.GONE

            list = Paper.book().read<ArrayList<ListModel>>("LIST_MODEL")!!

            val adapter = ArticleAdapter(list, this)
            rv_search_results.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
            rv_search_results.adapter = adapter
            rv_search_results.setHasFixedSize(true)
            rv_search_results.isNestedScrollingEnabled = false
        } else {
            rv_search_results.visibility = View.GONE
            tv_no_results.visibility = View.VISIBLE
        }
    }

    override fun onArticleClicked(pos: Int) {
        val openURL = Intent(Intent.ACTION_VIEW)
        openURL.data = Uri.parse(list[pos].webUrl)
        startActivity(openURL)
    }
}