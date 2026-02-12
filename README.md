# MyFood

[![Android CI/CD](https://github.com/oussemaAr/MyFood/actions/workflows/android.yml/badge.svg)](https://github.com/oussemaAr/MyFood/actions/workflows/android.yml)

MyFood is an Android application designed to help users discover, view, and manage food recipes. This project showcases modern Android development practices, leveraging the latest libraries and architectural patterns.

## Features

### Current Features

*   **Recipe Browsing**: Users can browse a list of recipes.
*   **Recipe Search**: Users can search for recipes by name or ingredients.
*   **Recipe Details**: View detailed information about a recipe, including ingredients, instructions, and nutritional facts.
*   **Market Integration**: Display market-related information for ingredients (e.g., where to buy).
*   **Product Information**: View details about individual food products.

### Potential Future Features

*   **User Authentication**: Allow users to create accounts, log in, and personalize their experience.
*   **Favorite Recipes**: Enable users to save their favorite recipes for quick access.
*   **Shopping List**: Generate a shopping list based on selected recipes or individual ingredients.
*   **Meal Planner**: Plan meals for the week and manage ingredients.
*   **Custom Recipes**: Allow users to add their own recipes to the app.
*   **Offline Support**: Cache recipes and other data for offline viewing.
*   **Personalized Recommendations**: Suggest recipes based on user preferences or past interactions.
*   **Recipe Ratings & Reviews**: Users can rate and review recipes.
*   **Dietary Filters**: Filter recipes by dietary restrictions (e.g., vegetarian, vegan, gluten-free).

## Architecture

MyFood follows a Clean Architecture approach, separating concerns into distinct layers to promote maintainability, testability, and scalability.

### Layers

1.  **UI Layer (Presentation)**:
    *   Built with **Jetpack Compose** for a declarative UI.
    *   Uses **ViewModels** to hold and manage UI-related data in a lifecycle-conscious way, surviving configuration changes.
    *   Handles user interactions and observes data from the ViewModel.

2.  **Domain Layer**:
    *   Contains the business logic and core entities of the application.
    *   **Use Cases (Interactors)**: Encapsulate specific business rules and orchestrate data flow between the UI and Data layers. They are responsible for a single piece of functionality.
    *   **Entities**: Plain Kotlin data classes representing the core business objects (e.g., `RecipeEntity`, `ProductEntity`).

3.  **Data Layer**:
    *   Responsible for fetching, storing, and managing application data.
    *   **Repositories**: Abstracts data sources, providing a clean API to the Domain layer. They decide whether to fetch data from the network, database, or other sources.
    *   **Data Sources**: Implementations for fetching data from specific sources (e.g., `RecipeRemoteDataSource`, `ProductLocalDataSource`).
    *   **Data Transfer Objects (DTOs)**: Data models used for network communication or database storage, often mapped to Domain Entities.

### Technologies & Libraries

*   **Kotlin**: The primary language for Android development.
*   **Jetpack Compose**: Modern toolkit for building native Android UI.
*   **Hilt**: Dependency Injection framework for Android, built on top of Dagger. It simplifies dependency management and provides a standard way to incorporate Dagger into Android apps.
*   **Kotlin Coroutines & Flow**: For asynchronous programming and reactive data streams.
*   **Ktor Client**: A multiplatform asynchronous HTTP client for making network requests.
*   **Kotlinx Serialization**: A serialization library for Kotlin that allows easy conversion of Kotlin objects to JSON and vice-versa (used with Ktor for API communication).
*   **Coil**: An image loading library for Android backed by Kotlin Coroutines.
*   **Android Architecture Components**: ViewModel, LiveData/Flow for robust and testable app architecture.
