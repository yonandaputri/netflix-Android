package com.example.netflix_app.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.netflix_app.config.RetrofitBuilder
import retrofit2.create

class MovieViewModel : ViewModel() {
    val movieRepository: MovieRepository

    init {
        val movieAPI = RetrofitBuilder.createRetrofit().create(MovieAPI::class.java)
        movieRepository = MovieRepository(movieAPI)
    }

    val movie: LiveData<Movie> = movieRepository.movie
    val listMovie: MutableLiveData<List<Movie>> = movieRepository.listMovie

    fun getListMovie() {
        movieRepository.getMovies()
    }

    fun getMovie(id: String) {
        movieRepository.getMovieById(id)
    }

    fun saveMovie(movie: Movie) {
        movieRepository.saveMovie(movie)
    }
}