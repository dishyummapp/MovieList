package `in`.hashcoder.movielist.model_classes

import com.google.gson.annotations.SerializedName

data class MovieList(
    @SerializedName("count")
    val count: Int? = null,

    @SerializedName("next")
    val next: String? = null,

    @SerializedName("previous")
    val previous: String? = null,

    @SerializedName("results")
    val results: List<Movie>? = null
)