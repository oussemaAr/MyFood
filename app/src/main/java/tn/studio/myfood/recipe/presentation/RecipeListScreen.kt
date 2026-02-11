package tn.studio.myfood.recipe.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage

@Composable
fun RecipeList(viewModel: RecipeViewModel = viewModel()) {

    val state = viewModel.state.collectAsState()
    LaunchedEffect(Unit) {
        viewModel.fetchRecipes()
    }

    LazyColumn {
        items(state.value) { item ->
            Column {
                AsyncImage(
                    model = item.image,
                    contentDescription = null,
                )
                Text(item.name)
            }
        }
    }
}

