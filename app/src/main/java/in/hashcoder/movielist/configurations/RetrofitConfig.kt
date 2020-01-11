package `in`.hashcoder.movielist.configurations

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitConfig {

    private val retrofit: Retrofit.Builder by lazy{
        Retrofit.Builder()
            .baseUrl("https://swapi.co/")
            .addConverterFactory(GsonConverterFactory.create())
    }

    val apiInterface: ApiInterface by lazy {
        retrofit
            .build()
            .create(ApiInterface::class.java)
    }
}