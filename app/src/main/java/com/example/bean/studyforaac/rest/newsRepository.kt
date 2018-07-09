package com.example.bean.studyforaac.rest

import android.arch.lifecycle.LiveData
import com.example.bean.studyforaac.model.newsItem
import retrofit2.Response
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import retrofit2.Call
import retrofit2.Callback


object newsRepository {

    fun getHeadline(category: String) : LiveData<List<newsItem>>{

        val data = MutableLiveData<List<newsItem>>()

        val call = APIUtils.newsAPIService.getHeadlines(category)

        call.enqueue(object : Callback<List<newsItem>> {
            override fun onResponse(call: Call<List<newsItem>>?, response: Response<List<newsItem>>?) {
                Log.i("??", "?????????????????")
                Log.i("??", "?????????????????")
                Log.i("??", "?????????????????")
                Log.i("??", "?????????????????")

            }

            override fun onFailure(call: Call<List<newsItem>>?, t: Throwable?) {

                Log.i("!!", "!!!!!!!!!!!!")
                Log.i("!!", "!!!!!!!!!!!!")
                Log.i("!!", "!!!!!!!!!!!!")
                Log.i("!!", "!!!!!!!!!!!!")
            }
        })


        return data
    }
}