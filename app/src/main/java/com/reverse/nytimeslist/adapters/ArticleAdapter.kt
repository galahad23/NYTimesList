package com.reverse.nytimeslist.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.reverse.nytimeslist.R
import com.reverse.nytimeslist.listeners.ArticleListener
import com.reverse.nytimeslist.models.ListModel
import com.reverse.nytimeslist.viewHolders.ArticleViewHolder

class ArticleAdapter(
    private var items: List<ListModel>,
    private var listener: ArticleListener
) : RecyclerView.Adapter<ArticleViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        var appsViewHolder: ArticleViewHolder? = null

        appsViewHolder = ArticleViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.row_search_article, parent, false)
        )

        return appsViewHolder
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) =
        holder.bind(items[position], listener)
}