package com.reverse.nytimeslist.uis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.reverse.nytimeslist.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_search_articles.setOnClickListener(this)
        tv_most_emailed.setOnClickListener(this)
        tv_most_shared.setOnClickListener(this)
        tv_most_viewed.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            tv_search_articles -> {
                startActivity(Intent(this, ArticleSearchActivity::class.java))
            }
            tv_most_emailed -> {

            }
            tv_most_shared -> {

            }
            tv_most_viewed -> {

            }
        }
    }
}