package com.example.netflix_app.screen

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels

import com.example.netflix_app.R
import com.example.netflix_app.movie.MovieViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_show_detail_movie.*

/**
 * A simple [Fragment] subclass.
 * Use the [ShowDetailMovieFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShowDetailMovieFragment : Fragment() {

    val movieViewModel by activityViewModels<MovieViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_show_detail_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val duration = arguments?.getString("duration")
        show_synopsis_movie.text = arguments?.getString("synopsis")
        duration_movie_show.text = "${duration} min"
        println(arguments?.getString("imageUrl"))
        Picasso.get().load(arguments?.getString("imageUrl")).into(image_movie_show)
    }
}
