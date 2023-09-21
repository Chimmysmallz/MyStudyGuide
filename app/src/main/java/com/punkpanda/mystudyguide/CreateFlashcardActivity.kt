package com.punkpanda.mystudyguide

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import com.punkpanda.mystudyguide.models.Flashcard

// In CreateFlashcardActivity.kt

class CreateFlashcardActivity : AppCompatActivity() {

    private lateinit var questionEditText: EditText
    private lateinit var answerEditText: EditText
    private lateinit var categorySpinner: Spinner
    private lateinit var saveFlashcardButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_flashcard)

        // Initialize UI elements
        questionEditText = findViewById(R.id.questionEditText)
        answerEditText = findViewById(R.id.answerEditText)
        categorySpinner = findViewById(R.id.categorySpinner)
        saveFlashcardButton = findViewById(R.id.saveFlashcardButton)

        // Set a click listener for the Save button
        saveFlashcardButton.setOnClickListener {
            saveFlashcard()
        }
    }

    private fun saveFlashcard() {
        val question = questionEditText.text.toString()
        val answer = answerEditText.text.toString()
        val category = categorySpinner.selectedItem.toString() // Get the selected category from the spinner

        // Validate input (e.g., check if fields are not empty)

        // Create a new flashcard object with the entered data
        val newFlashcard = Flashcard(question, answer, category)

        // Save the flashcard to your data source (e.g., database)
        // Example: flashcardRepository.saveFlashcard(newFlashcard)

        // Optionally, you can navigate back to the main activity or perform other actions
        finish()
    }
}
