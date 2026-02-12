package tn.studio.myfood.recipe.domain

interface RecipeRepository {
    suspend fun fetchListRecipes(): Result<List<RecipeEntity>>
    suspend fun fetchRecipeById(id: String): Result<RecipeEntity>
}