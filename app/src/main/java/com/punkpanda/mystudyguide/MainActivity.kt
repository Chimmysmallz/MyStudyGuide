package com.punkpanda.mystudyguide

import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import androidx.navigation.NavDirections
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.punkpanda.mystudyguide.models.Flashcard
import com.punkpanda.mystudyguide.MainFragment
import android.content.Intent
import com.punkpanda.mystudyguide.MainFragmentDirections


class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the NavController using the NavHostFragment
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        // Create individual flashcards
        val flashcard1 = Flashcard("What is the capital of France?", "Paris", "Geography")
        val flashcard2 = Flashcard("What is 2 + 2?", "4", "Math")

        // Access properties of a flashcard
        val question = flashcard1.question // This will be "What is the capital of France?"
        val answer = flashcard1.answer     // This will be "Paris"
        val category = flashcard1.category // This will be "Geography"

        // Create a list of flashcards
        val flashcards = listOf(
            Flashcard("What is the capital of France?", "Paris", "Geography"),
            Flashcard("What is 2 + 2?", "4", "Math"),
            // Add more flashcards here
        )

        // Initialize the RecyclerView and set its adapter
        val recyclerView: RecyclerView = findViewById(R.id.flashcardRecyclerView)
        val adapter = FlashcardAdapter(flashcards)
        recyclerView.adapter = adapter
    }

    // Function to navigate to the quiz activity
    fun startQuiz(view: View) {
        val intent = Intent(this, QuizActivity::class.java)
        startActivity(intent)
    }

    // Function to navigate to the flashcard creation activity
    fun createFlashcard(view: View) {
        val action = MainFragmentDirections.actionMainToCreate()
        val directions: MainFragmentDirections = action
        navController.navigate(directions)
    }
}

private fun NavController.navigate(mainFragmentDirections: MainFragmentDirections) {

}
