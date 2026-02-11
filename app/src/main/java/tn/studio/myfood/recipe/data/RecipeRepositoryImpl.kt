package tn.studio.myfood.recipe.data

import tn.studio.myfood.recipe.data.mapper.toDomain
import tn.studio.myfood.recipe.domain.RecipeEntity
import tn.studio.myfood.recipe.domain.RecipeRepository
import javax.inject.Inject

class RecipeRepositoryImpl @Inject constructor(
    val dataSource: RecipeDataSource
) : RecipeRepository {
    override suspend fun fetchListRecipes(): List<RecipeEntity> {
        return dataSource.fetchRecipes()?.toDomain().orEmpty()
    }

    override suspend fun fetchRecipeById(id: String): RecipeEntity {
        TODO("Not yet implemented")
    }
}