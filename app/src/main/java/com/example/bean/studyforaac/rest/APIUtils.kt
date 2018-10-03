package com.example.bean.studyforaac.rest

object APIUtils {
    val newsAPIService : NewsAPIService by lazy {  RestClient.Instance().create(NewsAPIService::class.java) }

}