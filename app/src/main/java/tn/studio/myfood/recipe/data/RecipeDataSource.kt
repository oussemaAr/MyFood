package tn.studio.myfood.recipe.data

import android.util.Log
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.HttpStatusCode
import tn.studio.myfood.common.NetworkClient
import tn.studio.myfood.recipe.data.dto.RecipeApiResponse
import javax.inject.Inject

class RecipeDataSource @Inject constructor(
    val networkClient: NetworkClient
) {

    suspend fun fetchRecipes(): RecipeApiResponse? {
        return try {
            val result = networkClient.client
                .get("v1/recipes")

            if (result.status == HttpStatusCode.OK) {
                result.body()
            } else {
                null
            }
        } catch (ex: Exception) {
            Log.e("TAG", "fetchRecipes: $ex")
            null
        }
    }

}