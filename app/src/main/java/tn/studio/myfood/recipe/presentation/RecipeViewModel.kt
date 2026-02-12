package tn.studio.myfood.recipe.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import tn.studio.myfood.recipe.domain.usecase.FetchAllRecipesUseCase
import javax.inject.Inject

@HiltViewModel
class RecipeViewModel @Inject constructor(
    private val fetchAllRecipesUseCase: FetchAllRecipesUseCase
) : ViewModel() {

    private var _state = MutableStateFlow(RecipeUIState())
    val state: StateFlow<RecipeUIState> = _state

    fun fetchRecipes() = viewModelScope.launch {
        _state.update {
            it.copy(
                isLoading = true,
            )
        }
        val result = fetchAllRecipesUseCase()
        result.fold(
            onSuccess = { data ->
                _state.update {
                    it.copy(
                        isLoading = false,
                        data = data
                    )
                }
            },
            onFailure = { error ->
                _state.update {
                    it.copy(
                        isLoading = false,
                        isError = true,
                        errorMessage = error.message ?: "An unknown error occurred"
                    )
                }
            }
        )
    }
}