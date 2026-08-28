package com.example.postsapp

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

//text
@Composable
fun TextScreen() {
    var user by remember { mutableStateOf("Loading...") }

    LaunchedEffect(Unit) {
        user = getUserData()
    }

    Text(
        text = user,
        modifier = Modifier.padding(16.dp)
    )
}

suspend fun getUserData(): String {
    delay(1000) // Imagine API call delay
    return "Amey"
}

//list
@Composable
fun ListScreen() {
    var users by remember { mutableStateOf(listOf<User>()) }

    LaunchedEffect(Unit) {
        users = getUsers()
    }

    LazyColumn(
        modifier = Modifier.padding(16.dp)
    ) {
        items(users) { user ->
            Text(
                text = "Name: ${user.name}, Age: ${user.age}",
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

suspend fun getUsers(): List<User> {
    delay(1000) // Imagine API call delay

    return listOf(
        User("Amey", 34),
        User("Pavana", 31),
        User("Amit", 34),
        User("Sudeeksha", 32)
    )
}

data class User(val name: String, val age: Int)

//form
@Composable
fun FormScreen() {
    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = age,
            onValueChange = { age = it },
            label = { Text("Age") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                showInputToast(context, name, age)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Submit")
        }
    }
}

fun showInputToast(context: Context, name: String, age: String) {
    Toast.makeText(context, "Name: $name, Age: $age", Toast.LENGTH_SHORT).show()
}

