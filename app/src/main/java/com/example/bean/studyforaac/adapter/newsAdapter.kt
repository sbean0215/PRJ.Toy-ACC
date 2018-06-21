package com.example.bean.studyforaac.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.bean.studyforaac.R
import com.example.bean.studyforaac.model.newsItem
import kotlinx.android.synthetic.main.news_item.view.*


// 1.     class newsAdapter: RecyclerView.Adapter<newsAdapter.viewHolder>{
//          constructor()
class newsAdapter (val items: MutableList<newsItem>, val context: Context?) : RecyclerView.Adapter<newsAdapter.viewHolder>() {

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val item = items[position]

// 1.        holder.mTitle.setText(items[position].title)
        holder?.mTitle?.text = item.title
        holder?.mDescription?.text = item.description
        holder?.mPublishedTime?.text = item.publishedAt
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        return viewHolder(LayoutInflater.from(context).inflate(R.layout.news_item, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class viewHolder (view: View) : RecyclerView.ViewHolder(view) {

        //  1.      val mTitle: TextView by lazy { view.findViewById(R.id.title_tv) as TextView }
        //  2.      val mTitle: TextView = view.findViewById(R.id.title_tv)

        //  3.      val mTitle: TextView
        //        init {
        //            mTitle = view.findViewById(R.id.title)
        //        }

        val mTitle: TextView = view.title_tv
        val mDescription: TextView = view.description_tv
        val mPublishedTime: TextView = view.published_time_tv
        val mNewsTitleImg: ImageView = view.news_title_iv

    }
}