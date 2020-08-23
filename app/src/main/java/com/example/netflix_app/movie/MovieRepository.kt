package com.example.netflix_app.movie

import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieRepository(val movieAPI: MovieAPI) {
    var movie: MutableLiveData<Movie> = MutableLiveData<Movie>()
    var listMovie: MutableLiveData<List<Movie>> = MutableLiveData<List<Movie>>()

    fun getMovies() {
        movieAPI.getMovies().enqueue(object: Callback<List<Movie>>{
            override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {
                if (response.code() == 200) {
                    val gson = Gson().toJson(response.body())
                    val data: List<Movie> = Gson().fromJson(gson, Array<Movie>::class.java).toList()
                    listMovie.value = data
                } else  {
                    println("GAGAL ${response.code()}")
                }
            }
        })
    }

    fun getMovieById(id: String) {
        movieAPI.getMovieById(id).enqueue(object: Callback<Movie>{
            override fun onFailure(call: Call<Movie>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                if (response.code() == 200) {
                    movie.value = response.body()
                }
            }
        })
    }

    fun saveMovie(movie: Movie) {
        movieAPI.createMovie(movie).enqueue(object: Callback<Movie>{
            override fun onFailure(call: Call<Movie>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                println(response.isSuccessful)
            }
        })
    }
}