package com.reverse.nytimeslist.viewHolders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.reverse.nytimeslist.AppUtil
import com.reverse.nytimeslist.listeners.ArticleListener
import com.reverse.nytimeslist.models.ListModel
import kotlinx.android.synthetic.main.row_search_article.view.*

class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

    private var listener: ArticleListener? = null

    override fun onClick(v: View?) {
        when (v) {
            itemView -> {
                listener?.onArticleClicked(adapterPosition)
            }
        }
    }

    fun bind(item: ListModel, button: ArticleListener) {
        listener = button

        itemView.tv_article_title.text = item.title
        itemView.tv_article_date.text = item.date
        itemView.setOnClickListener(this)
    }
}