package ru.skillbox.a21_networking.movie_search

import android.util.Log
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import org.json.JSONException
import org.json.JSONObject
import ru.skillbox.a21_networking.network.Network
import java.io.IOException

class MovieSearchRepository {

    fun searchMovie(text: String, callback: (List<RemoteMovie>) -> Unit): Call {
        return Network.getSearchMovieCall(text).apply {
            enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    Log.e("Server", "execute request error = ${e.message}", e)
                    callback(emptyList())
                }

                override fun onResponse(call: Call, response: Response) {
                    if(response.isSuccessful) {
                        val responseString = response.body?.string().orEmpty()
                        val movies = parseMovieResponse(responseString)
                        callback(movies)
                    } else {
                        callback(emptyList())
                    }
                }
            })
        }
    }

    private fun parseMovieResponse(responseBodyString: String): List<RemoteMovie> {
        return try {
            val jsonObject = JSONObject(responseBodyString)
            val movieArray = jsonObject.getJSONArray("Search")

            (0 until movieArray.length()).map {index -> movieArray.getJSONObject(index)}
                .map { movieJsonObject ->
                    val title = movieJsonObject.getString("Title")
                    val year = movieJsonObject.getString("Year")
                    val id = movieJsonObject.getString("imdbID")
                    RemoteMovie(id= id, title= title, year= year)
                }
        } catch (e:JSONException) {
            Log.e("Server", "parse response error = ${e.message}", e)
            emptyList()
        }
    }
}