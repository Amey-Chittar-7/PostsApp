package com.example.postsapp.samplemoviedbapi

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun MovieScreen(
    viewModel: MovieViewModel
) {

    val movies = viewModel.getMovies()

    Column {

        movies.forEach { movie ->

            Text(text = movie)
        }
    }
}