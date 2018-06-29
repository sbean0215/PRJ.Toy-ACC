package com.example.bean.studyforaac.rest

object APIUtils {
    val newsAPIService : newsAPIService by lazy {  RestClient.Instance().create(newsAPIService::class.java) }

}