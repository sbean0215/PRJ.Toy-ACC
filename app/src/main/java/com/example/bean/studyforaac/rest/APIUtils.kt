package com.example.bean.studyforaac.rest

class APIUtils {
    fun getAPIService(): APIService? {
        return RestClient.clientInstance().create(APIService::class.java)
    }
}