package com.example.bean.studyforaac.rest

import android.arch.lifecycle.LiveData
import com.example.bean.studyforaac.model.newsItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPIService {
    @GET("/v2/top-headlines?country=kr")
    fun getHeadlines(@Query("category") category: String): Call<List<newsItem>>
}