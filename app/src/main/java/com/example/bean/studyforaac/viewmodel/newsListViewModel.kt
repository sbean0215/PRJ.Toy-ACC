package com.example.bean.studyforaac.viewmodel

import android.app.Application
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.bean.studyforaac.model.newsItem
import com.example.bean.studyforaac.rest.newsRepository

class newsListViewModel(val category: String) : ViewModel() {
//    lateinit var newsList : MutableLiveData<List<newsItem>>
    val newsList : MutableLiveData<List<newsItem>>

    init {
        newsList = newsRepository.getHeadline(category) as MutableLiveData<List<newsItem>>
    }

    class Factory(val category:String) : ViewModelProvider.NewInstanceFactory() {

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return newsListViewModel(category) as T
        }
    }
}