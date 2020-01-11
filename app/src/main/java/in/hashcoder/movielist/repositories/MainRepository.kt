package `in`.hashcoder.movielist.repositories

import `in`.hashcoder.movielist.configurations.RetrofitConfig
import `in`.hashcoder.movielist.model_classes.Movie
import `in`.hashcoder.movielist.model_classes.MovieList
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object MainRepository {

    fun getMovies(): LiveData<MovieList> {
        val data: MutableLiveData<MovieList> = MutableLiveData()

        val call: Call<MovieList> = RetrofitConfig.apiInterface.getMoviesList()
        call.enqueue(object : Callback<MovieList>{
            override fun onFailure(call: Call<MovieList>, t: Throwable) {
                data.value = null
                t.printStackTrace()
            }

            override fun onResponse(call: Call<MovieList>, response: Response<MovieList>) {
                if (!response.isSuccessful) {
                    data.value = null
                }
                else {
                    data.value = response.body()
                }
            }
        })

        return data
    }

    fun getMovieDetails(url: String) : LiveData<Movie> {
        val data: MutableLiveData<Movie> = MutableLiveData()

        val call: Call<Movie> = RetrofitConfig.apiInterface.getMovieDetails(url)
        call.enqueue(object : Callback<Movie> {
            override fun onFailure(call: Call<Movie>, t: Throwable) {
                data.value = null
                t.printStackTrace()
            }

            override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                println(response)
                if (!response.isSuccessful) {
                    data.value = null
                }
                else {
                    data.value = response.body()
                }
            }
        })

        return data
    }

}