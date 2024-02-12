package com.example.firebaseapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.firebaseapp.ui.theme.FirebaseAppTheme
import com.google.firebase.Firebase
import com.google.firebase.database.database

data class Animal(val name: String, val age: Float, val description: String)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val chipmunk = Animal("Бурундук", .5f, "Милый")
        val beaver = Animal("Бобер", 2f, "Любит бревно")
        val minipig = Animal("Минипиг", 2f, "Максим Дубков")

        val database = Firebase.database
        val myRef = database.getReference("message")

        myRef.child(chipmunk.name).setValue(chipmunk)
        myRef.child(beaver.name).setValue(beaver)
        myRef.child(minipig.name).setValue(minipig)

        setContent {
            FirebaseAppTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
            text = "Hello $name!",
            modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FirebaseAppTheme {
        Greeting("Android")
    }
}