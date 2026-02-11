package tn.studio.myfood.recipe.data.mapper

import tn.studio.myfood.recipe.data.dto.RecipeApiResponse
import tn.studio.myfood.recipe.domain.RecipeEntity


fun RecipeApiResponse.toDomain(): List<RecipeEntity> {
    return this.data?.map { item ->
        RecipeEntity(
            id = item?.id.toString(),
            name = item?.title.orEmpty(),
            image = item?.imageUrl.orEmpty(),
        )
    }.orEmpty()
}