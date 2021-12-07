package ru.skillbox.a21_networking.network

import okhttp3.Call
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import ru.skillbox.a21_networking.movie_search.API_KEY

object Network {
    val client = OkHttpClient.Builder()
        .build()

    fun getSearchMovieCall(text: String): Call {
        //http://www.omdbapi.com/?apikey=[yourkey]&s=

        val url = HttpUrl.Builder()
            .scheme("http")
            .host("www.omdbapi.com")
            .addQueryParameter("apikey", API_KEY)
            .addQueryParameter("s", text)
            .build()

        val request = Request.Builder()
            .get()
            .url(url)
            .build()

        return client.newCall(request)
    }
}