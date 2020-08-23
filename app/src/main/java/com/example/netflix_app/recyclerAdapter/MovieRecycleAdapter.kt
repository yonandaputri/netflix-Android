package com.example.netflix_app.recyclerAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentActivity
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.netflix_app.R
import com.example.netflix_app.movie.Movie
import com.squareup.picasso.Picasso

class MovieRecycleAdapter(
    private val movieList: List<Movie>,
    private val activity: FragmentActivity?
) : RecyclerView.Adapter<MovieViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_item_layout, parent, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        println("$position ${movieList[position].title}")
        Picasso.get().load(movieList[position].imageUrl).into(holder.imageMovie)

        val bundle = bundleOf(
            Pair("imageUrl", movieList[position].imageUrl),
            Pair("synopsis", movieList[position].synopsis),
            Pair("duration", movieList[position].duration)
        )
        holder.imageMovie.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_movieFragment_to_showDetailMovieFragment, bundle)
        }
    }

}

class MovieViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    val imageMovie = v.findViewById<ImageView>(R.id.image_movie)
}
