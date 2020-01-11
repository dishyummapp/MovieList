package `in`.hashcoder.movielist.adapters

import `in`.hashcoder.movielist.R
import `in`.hashcoder.movielist.model_classes.Movie
import `in`.hashcoder.movielist.views.MovieDetailsActivity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.movie_list_item.view.*

class MovieListAdapter(private val moviesList: List<Movie>?) : RecyclerView.Adapter<MovieListAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_list_item, parent, false))
    }

    override fun getItemCount(): Int {
        return moviesList!!.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(moviesList!![holder.adapterPosition])
    }

    class MovieViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val titleText: TextView = itemView.titleText
        val directorText: TextView = itemView.directorText
        val producerText: TextView = itemView.producerText
        val dateText: TextView = itemView.dateText

        fun bind(movie: Movie) {
            titleText.text = movie.title
            directorText.text = "Director: ${movie.director}"
            producerText.text = "Producer: ${movie.producer}"
            dateText.text = "Release Date: ${movie.releaseDate}"

            itemView.setOnClickListener {
                println(movie.url?.get(movie.url.length - 2))

                val intent = Intent(itemView.context, MovieDetailsActivity::class.java)
                intent.putExtra("id", movie.url?.get(movie.url.length - 2).toString())
                itemView.context.startActivity(intent)
            }
        }
    }
}