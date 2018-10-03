package com.example.bean.studyforaac.rest

//import java.awt.MediaTracker.LOADING
import android.support.annotation.NonNull


sealed class Resource<out T> {
    class loading<out T> : Resource<T>()
    data class success<out T>(val data: T?) : Resource<T>()
    data class error<out T>(val throwable: Throwable) : Resource<T>()
}