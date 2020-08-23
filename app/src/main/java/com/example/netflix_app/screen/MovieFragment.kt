package com.example.netflix_app.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.StaggeredGridLayoutManager

import com.example.netflix_app.R
import com.example.netflix_app.movie.MovieViewModel
import com.example.netflix_app.recyclerAdapter.MovieRecycleAdapter
import kotlinx.android.synthetic.main.fragment_movie.*

/**
 * A simple [Fragment] subclass.
 * Use the [MovieFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MovieFragment : Fragment() {

    val movieViewModel by activityViewModels<MovieViewModel>()
    lateinit var movieRecycleAdapter: MovieRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movie_recycler_view.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        movieViewModel.getListMovie()
        movieViewModel.listMovie.observe(viewLifecycleOwner, Observer {
            movieRecycleAdapter = MovieRecycleAdapter(it, activity)
            movie_recycler_view.adapter = movieRecycleAdapter
        })
    }
}
