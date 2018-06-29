package com.example.bean.studyforaac.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.bean.studyforaac.R
import com.example.bean.studyforaac.databinding.NewsItemBinding
import com.example.bean.studyforaac.model.newsItem
import com.example.bean.studyforaac.model.newsItemModel
import com.example.bean.studyforaac.view.newsClickCallBack

class newsAdapter (
        val mNewsNewsClickCallback: newsClickCallBack,
        val newsList: MutableList<newsItem>, val context: Context?) : RecyclerView.Adapter<newsAdapter.viewHolder>() {

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.binding.news = newsList[position] as newsItemModel?
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val binding : NewsItemBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.news_item,
                        parent, false)
        binding.callback = mNewsNewsClickCallback
        return viewHolder(binding)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    class viewHolder (binding: NewsItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val binding : NewsItemBinding = binding
    }
}