package com.example.postsapp.samplemoviedbapi

class MovieRepository {

    fun getMovies(): List<String> {
        return listOf(
            "Avengers",
            "Interstellar",
            "Inception"
        )
    }
}