package com.example.netflix_app.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels

import com.example.netflix_app.R
import com.example.netflix_app.movie.Movie
import com.example.netflix_app.movie.MovieViewModel
import kotlinx.android.synthetic.main.fragment_create_movie.*

/**
 * A simple [Fragment] subclass.
 * Use the [CreateMovieFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CreateMovieFragment : Fragment(), View.OnClickListener {

    val movieViewModel by activityViewModels<MovieViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        submit_movie_button.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            submit_movie_button -> {
                val title = input_title_movie.text.toString()
                val duration = input_duration_movie.text.toString()
                val imageUrl = input_image_movie.text.toString()
                val synopsis = input_synopsis_movie.text.toString()
                if (title == "" || duration == "" || imageUrl == "" || synopsis == "") {
                    Toast.makeText(
                        view?.context,
                        "Input Data Movie Cann't Be Empty",
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    val movie = Movie(
                        title = title,
                        duration = duration,
                        imageUrl = imageUrl,
                        synopsis = synopsis
                    )
                    movieViewModel.saveMovie(movie)
                    Toast.makeText(
                        view?.context,
                        "Success Add New Movie!!",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }
}
