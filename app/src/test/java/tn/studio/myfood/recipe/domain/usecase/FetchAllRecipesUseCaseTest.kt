package tn.studio.myfood.recipe.domain.usecase

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.whenever
import tn.studio.myfood.recipe.domain.RecipeEntity
import tn.studio.myfood.recipe.domain.RecipeRepository
import java.util.concurrent.TimeoutException


class FetchAllRecipesUseCaseTest {

    // SUT => FetchAllRecipesUseCase
    // Dependency => RecipeRepository (Mockk)
    // Happy Path => return success list of recipes check list order
    // Edge Case => return failed

    lateinit var classUnderTest: FetchAllRecipesUseCase

    @Mock
    lateinit var repository: RecipeRepository

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        classUnderTest = FetchAllRecipesUseCase(repository)
    }

    @Test
    fun `GIVEN list of recipes WHEN fetching recipes THEN return a sorted list by name`() = runTest {
        // GIVEN
        val actualList = listOf(
            RecipeEntity("1", "A", "A"),
            RecipeEntity("2", "A", "B"),
            RecipeEntity("3", "A", "D"),
            RecipeEntity("4", "A", "C"),
        )

        val expectedResult = listOf(
            RecipeEntity("3", "A", "D"),
            RecipeEntity("4", "A", "C"),
            RecipeEntity("2", "A", "B"),
            RecipeEntity("1", "A", "A"),
        )

        // WHEN
        whenever {
            repository.fetchListRecipes()
        }.thenReturn(Result.success(actualList))

        val actualResult = classUnderTest()
        // THEN

        assertTrue("use return success", actualResult.isSuccess)
        assertEquals(expectedResult, actualResult.getOrNull())
    }

    @Test
    fun `GIVEN timeout exception WHEN fetching recipes THEN return failure`() = runTest {
        // GIVEN
        val expectedResult = TimeoutException()
        // WHEN
        whenever {
            repository.fetchListRecipes()
        }.thenReturn(Result.failure(expectedResult))
        val actualResult = classUnderTest()
        // THEN
        assert(actualResult.isFailure)
        assertEquals(actualResult.exceptionOrNull(), expectedResult)
    }
}