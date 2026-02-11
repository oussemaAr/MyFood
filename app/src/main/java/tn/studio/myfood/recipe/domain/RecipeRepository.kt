package tn.studio.myfood.recipe.domain

interface RecipeRepository {
    suspend fun fetchListRecipes(): List<RecipeEntity>
    suspend fun fetchRecipeById(id: String): RecipeEntity
}