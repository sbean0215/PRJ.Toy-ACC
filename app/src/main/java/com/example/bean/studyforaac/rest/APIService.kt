package com.example.bean.studyforaac.rest

import okhttp3.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {
    @GET("/v2/top-headlines?country=kr")
    fun getHeadlines(@Query("category") category: String): Call
}