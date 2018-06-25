package com.example.bean.studyforaac.rest

object APIUtils {
    val newsAPIService : APIService by lazy {  RestClient.Instance().create(APIService::class.java) }

    fun getAPIService(): APIService {
        return newsAPIService
    }
}