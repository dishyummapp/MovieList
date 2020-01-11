package `in`.hashcoder.movielist.viewmodels

import `in`.hashcoder.movielist.model_classes.Movie
import `in`.hashcoder.movielist.model_classes.MovieList
import `in`.hashcoder.movielist.repositories.MainRepository
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class MainViewModel(application: Application): AndroidViewModel(application) {

    fun getMovies(): LiveData<MovieList> {
        return MainRepository.getMovies()
    }

    fun getMovieDetails(url: String): LiveData<Movie> {
        return MainRepository.getMovieDetails(url)
    }
}