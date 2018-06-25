package com.example.bean.studyforaac.rest

import android.util.Log
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

class RestClient {

    private val TAG = "OkHttpRetrofitClient"

    companion object {
        //https://newsapi.org/s/south-korea-news-api
        //https://newsapi.org/v2/top-headlines?country=kr&category=business&apiKey=API_KEY
        val API_BASE_URL: String = "https://newsapi.org";

        fun Instance(): Retrofit{
            val okHttpClient: OkHttpClient = OkHttpClient.Builder()
                    .addNetworkInterceptor(HeaderSettingInterceptor())
                    .build()

            val retrofit: Retrofit = Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            return retrofit
        }
    }

    private class HeaderSettingInterceptor : Interceptor {
        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): Response {
            val original = chain.request()

           /* HttpUrl url = chain.request().httpUrl()
                .newBuilder()
                .addQueryParameter("api_key", mApiKey)
                .build();
        Request request = chain.request().newBuilder().url(url).build();
        return chain.proceed(request);
        */
            val url = original.url().newBuilder()
                    .addQueryParameter("apiKey", "key")
                    .build()

            val request = original.newBuilder()
//                    .addHeader("", "")
                    //TODO url intercept 해서 apiKey 넣을것
                    .url(url)
                    .method(original.method(), original.body())
                    .build()

            return chain.proceed(request)
        }
    }

}

/*
*

public class RestClient {

    private  static final String TAG = "RestClient";

    private static OkHttpClient okHttpClient;
    private static Retrofit retrofit;

    public static Retrofit getClientInstance() {
        if (retrofit == null) {

            okHttpClient = new OkHttpClient.Builder()
                    .addNetworkInterceptor(new HeaderSettingInterceptor())
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl("")
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    private static class HeaderSettingInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request original  = chain.request();

            Request request = original.newBuilder()
                    .builder.addHeader("", "")
                    .method(original.method(), original.body())
                    .build();

            return chain.proceed(request);
        }
    }
}

* */
