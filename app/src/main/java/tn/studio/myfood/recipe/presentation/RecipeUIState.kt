package tn.studio.myfood.recipe.presentation

import tn.studio.myfood.recipe.domain.RecipeEntity

data class RecipeUIState(
    val data: List<RecipeEntity> = emptyList(),
    val isLoading: Boolean = true,
    val isError : Boolean = false,
    val errorMessage: String? = null
)