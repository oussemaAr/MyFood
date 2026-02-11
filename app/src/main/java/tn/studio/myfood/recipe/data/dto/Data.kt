package tn.studio.myfood.recipe.data.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Data(
    @SerialName("category")
    val category: String?,
    @SerialName("cook_time")
    val cookTime: String?,
    @SerialName("description")
    val description: String?,
    @SerialName("directions")
    val directions: String?,
    @SerialName("id")
    val id: Int?,
    @SerialName("image_url")
    val imageUrl: String?,
    @SerialName("ingredients")
    val ingredients: String?,
    @SerialName("nutrition")
    val nutrition: Nutrition? = null,
    @SerialName("prep_time")
    val prepTime: String?,
    @SerialName("rating")
    val rating: String?,
    @SerialName("scraped_at")
    val scrapedAt: String?,
    @SerialName("servings")
    val servings: String?,
    @SerialName("title")
    val title: String?,
    @SerialName("total_time")
    val totalTime: String?,
    @SerialName("url")
    val url: String?
)