package com.example.bean.studyforaac.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.bean.studyforaac.model.newsItem

class articleAdapter : RecyclerView.Adapter<articleAdapter.articleViewholder>{

    lateinit var context: Context
    var articles : MutableList<newsItem>? = null

    constructor(context : Context) {
        this.context = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): articleViewholder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: articleViewholder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class articleViewholder: RecyclerView.ViewHolder {
        constructor(itemView: View?) : super(itemView)
    }
}