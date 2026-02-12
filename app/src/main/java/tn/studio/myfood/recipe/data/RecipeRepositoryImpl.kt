package tn.studio.myfood.recipe.data

import tn.studio.myfood.recipe.data.mapper.toDomain
import tn.studio.myfood.recipe.domain.RecipeEntity
import tn.studio.myfood.recipe.domain.RecipeRepository
import javax.inject.Inject

class RecipeRepositoryImpl @Inject constructor(
    val dataSource: RecipeDataSource
) : RecipeRepository {
    override suspend fun fetchListRecipes(): Result<List<RecipeEntity>> {
        return dataSource.fetchRecipes().map { it.toDomain() }
    }

    override suspend fun fetchRecipeById(id: String): Result<RecipeEntity> {
        TODO("Not yet implemented")
    }
}