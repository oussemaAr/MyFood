package tn.studio.myfood.DI

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import tn.studio.myfood.common.NetworkClient
import tn.studio.myfood.recipe.data.RecipeDataSource
import tn.studio.myfood.recipe.data.RecipeRepositoryImpl
import tn.studio.myfood.recipe.domain.RecipeRepository
import tn.studio.myfood.recipe.domain.usecase.FetchAllRecipesUseCase
import tn.studio.myfood.recipe.presentation.RecipeViewModel

@Module
@InstallIn(SingletonComponent::class)
class RecipeModule {

    @Provides
    fun providesNetworkClient() = NetworkClient

    @Provides
    fun providesDataSource(networkClient: NetworkClient) = RecipeDataSource(networkClient)

    @Provides
    fun providesRecipeRepository(dataSource: RecipeDataSource): RecipeRepository =
        RecipeRepositoryImpl(dataSource)

    @Provides
    fun providesFetchAllRecipesUseCase(repository: RecipeRepository) =
        FetchAllRecipesUseCase(repository)

    @Provides
    fun providesRecipeViewModel(useCase: FetchAllRecipesUseCase) = RecipeViewModel(useCase)
}