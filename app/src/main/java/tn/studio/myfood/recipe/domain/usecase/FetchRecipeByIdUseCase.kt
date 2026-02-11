package tn.studio.myfood.recipe.domain.usecase

import tn.studio.myfood.recipe.domain.RecipeRepository

class FetchRecipeByIdUseCase(
    private val repository: RecipeRepository
) {

    suspend operator fun invoke(id: String) = repository
        .fetchRecipeById(id)
}
