package tn.studio.myfood.recipe.data.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Nutrition(
    @SerialName("Calories")
    val calories: String? = "",
    @SerialName("Carbohydrates")
    val carbohydrates: String? = "",
    @SerialName("Cholesterol")
    val cholesterol: String? = "",
    @SerialName("Fat")
    val fat: String? = "",
    @SerialName("Fiber")
    val fiber: String? = "",
    @SerialName("Protein")
    val protein: String? = "",
    @SerialName("Saturated Fat")
    val saturatedFat: String? = "",
    @SerialName("Sodium")
    val sodium: String? = "",
    @SerialName("Sugar")
    val sugar: String? = ""
)