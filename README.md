# Zemoga Test Android

## Frameworks and Libraries
- Programming language: Kotlin
- Jetpack compose for UI implementation
- Hilt for dependency injection
- Custom navigation component for navigation
- Ktor and OkHttp for HTTP requests
- KotlinX-Serialization for JSON serialization/deserialization

The application make use of MVVM pattern and is split in three main packages in the source code
- **data:** Package containing the classes in charge of the requests to the API, the definition of the HTTP client is located here, there is also an interface to define the requests to the API, those requests are implemented in KtorRecipeApi class. Inside this package is also located the definition of the response models defined in the API

- **domain:** Package defined mainly to contain the logic of the business, through the use of UseCases that are injected to the view models. There's also the definition of the models to the level of the domain 

- **presentation:** Package containing screens implementation using compose, also the custom navigation is defined here, each screen has it's own model and it's own view model
