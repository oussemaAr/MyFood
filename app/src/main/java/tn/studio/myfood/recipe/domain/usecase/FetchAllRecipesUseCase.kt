package tn.studio.myfood.recipe.domain.usecase

import tn.studio.myfood.recipe.domain.RecipeRepository
import javax.inject.Inject

class FetchAllRecipesUseCase @Inject constructor(private val repository: RecipeRepository) {

    suspend operator fun invoke() = repository
        .fetchListRecipes()
        .sortedByDescending { newItem ->
            newItem.name
        }
}