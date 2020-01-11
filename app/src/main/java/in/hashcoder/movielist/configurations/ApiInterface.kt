package `in`.hashcoder.movielist.configurations

import `in`.hashcoder.movielist.model_classes.Character
import `in`.hashcoder.movielist.model_classes.Movie
import `in`.hashcoder.movielist.model_classes.MovieList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

    @GET("api/films/?format=json")
    fun getMoviesList(): Call<MovieList>

    @GET("api/films/{id}/?format=json")
    fun getMovieDetails(@Path("id") id: String) : Call<Movie>
}