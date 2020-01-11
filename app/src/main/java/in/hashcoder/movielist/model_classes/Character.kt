package `in`.hashcoder.movielist.model_classes

import com.google.gson.annotations.SerializedName

data class Character(
    @SerializedName("name")
    val name: String? = null,

    @SerializedName("height")
    val height: String? = null,

    @SerializedName("mass")
    val mass: String? = null,

    @SerializedName("hair_color")
    val hairColor: String? = null,

    @SerializedName("skin_color")
    val skinColor: String? = null,

    @SerializedName("eye_color")
    val eyeColor: String? = null,

    @SerializedName("birth_year")
    val birthYear: String? = null,

    @SerializedName("gender")
    val gender: String? = null,

    @SerializedName("homeworld")
    val homeWorld: String? = null,

    @SerializedName("films")
    val films: List<String>? = null,

    @SerializedName("species")
    val species: List<String>? = null,

    @SerializedName("vehicles")
    val vehicles: List<String>? = null,

    @SerializedName("starships")
    val starShips: List<String>? = null,

    @SerializedName("created")
    val created: String? = null,

    @SerializedName("edited")
    val edited: String? = null,

    @SerializedName("url")
    val url: String? = null
)