The Random Dog Image Generator is an Android application built using Jetpack Compose, Retrofit, Room Database, and Hilt. The app allows users to generate random images of dogs using an API and stores recently generated images locally for offline access.

Key Features:
✅ Fetch Random Dog Images – Uses Retrofit to call an API that retrieves random dog images.
✅ Store Recent Images – Saves up to 20 most recent images in a local Room Database for persistence.
✅ View Recent Images – Displays previously generated dog images from local storage.
✅ Offline Storage & Retrieval – Ensures that users can see their last generated images even without an internet connection.
✅ State Management with ViewModel – Utilizes MutableState, LiveData, and Flow to handle UI state efficiently.
✅ Dependency Injection with Hilt – Provides a scalable architecture for managing dependencies.

Tech Stack Used:
UI: Jetpack Compose
Networking: Retrofit + Gson
Local Storage: Room Database
Dependency Injection: Hilt
Image Loading & Caching: Glide
This app is designed to be simple, lightweight, and efficient, providing a seamless experience for users who love dogs! 🐶✨
