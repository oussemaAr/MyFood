package tn.studio.myfood.recipe.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage


@Composable
fun RecipeList(viewModel: RecipeViewModel = viewModel()) {

    val state = viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.fetchRecipes()
    }
    Box(modifier = Modifier.fillMaxSize()) {
        if (state.value.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        } else if (state.value.isError) {
            Column(modifier = Modifier.align(Alignment.Center)) {
                Text(
                    state.value.errorMessage ?: "Failed to load recipes. Please try again."
                )

                Button(onClick = {
                    viewModel.fetchRecipes()
                }) {
                    Text("Retry")
                }
            }
        } else {
            LazyColumn {
                items(
                    items = state.value.data,
                    key = { item -> item.id }
                ) { item ->
                    Column {
                        AsyncImage(
                            model = item.image,
                            contentDescription = "Image of ${item.name}",
                        )
                        Text(item.name)
                    }
                }
            }
        }
    }
}

