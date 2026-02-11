package tn.studio.myfood.recipe.data.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RecipeApiResponse(
    @SerialName("count")
    val count: Int?,
    @SerialName("data")
    val `data`: List<Data?>?,
    @SerialName("page")
    val page: Int?,
    @SerialName("success")
    val success: Boolean?
)