package com.example.postsapp.samplemoviedbapi

import androidx.lifecycle.ViewModel

class MovieViewModel(private val repository: MovieRepository) : ViewModel() {

    fun getMovies(): List<String> {
        return repository.getMovies()
    }
}