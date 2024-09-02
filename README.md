# The Movie Database App

The Movie Database is an online service similar to IMDB, where users can explore a comprehensive list of movies along with their descriptions, images, trailers, and more. This project utilizes The Movie Database API to fetch and display movie data.

[The Movie Database API Documentation](https://developers.themoviedb.org/3/getting-started/introduction)

## Features

- **Latest Movies**: Displays the latest movies with infinite scrolling.
- **Movie Details**: Allows users to view a simple page with detailed information about each movie.
- **UI with Jetpack Compose**: The user interface is built using Jetpack Compose, offering a modern and responsive design.

## Project Structure

The project is structured as a multi-module application, following the principles of Clean Architecture:

- **Common**: Contains shared utilities and constants used across modules.
- **Network**: Handles API requests
- **UI Elements**: Includes reusable UI components built with Jetpack Compose.
- **Features**:
  - **Movie List**: Displays the list of latest movies.
  - **Movie Details**: Shows detailed information about selected movies.
 
### Code Quality and Testing
## Code Quality
- **Clean Code:** The project emphasizes writing clean and maintainable code. The codebase is structured to be easy to read and understand, adhering to best practices.
- **SOLID Principles:** The architecture and code design follow SOLID principles, ensuring that the code is modular, flexible, and easy to extend. Each component has a single responsibility and is designed to interact with other components in a loosely-coupled manner.
- **Separation of Concerns:** The application is built with a clear separation of concerns, allowing each module to handle its specific responsibilities without overlap. This approach enhances readability and maintainability.

## Testing
- **Unit Testing:** Unit tests are included for core components, such as the MovieDetailsViewModel. These tests validate that individual units of code perform as expected.

- **UI Testing:** The project is designed to facilitate UI testing. The use of Jetpack Compose makes it straightforward to test UI components and interactions.

- **Note:** While UI tests are planned, the current implementation includes a solid foundation for integrating them in the future.
- **Testable Architecture:** The application's architecture supports easy addition of unit and UI tests. By focusing on testability, the code is designed to be robust and reliable, enabling effective testing throughout development.


## API Key Configuration

To run the project, you'll need to update the `NetWorkConstants` file with your API key:

```kotlin
const val API_KEY = "your_api_key_here"

