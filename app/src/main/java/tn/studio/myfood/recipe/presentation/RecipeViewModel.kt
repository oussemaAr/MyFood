package tn.studio.myfood.recipe.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import tn.studio.myfood.recipe.domain.RecipeEntity
import tn.studio.myfood.recipe.domain.usecase.FetchAllRecipesUseCase
import javax.inject.Inject

@HiltViewModel
class RecipeViewModel @Inject constructor(
    private val usecase: FetchAllRecipesUseCase
) : ViewModel() {

    private var _state = MutableStateFlow<List<RecipeEntity>>(emptyList())
    val state: StateFlow<List<RecipeEntity>> = _state


    fun fetchRecipes() = viewModelScope.launch {
        val recipes = usecase()
        _state.value = recipes
    }
}