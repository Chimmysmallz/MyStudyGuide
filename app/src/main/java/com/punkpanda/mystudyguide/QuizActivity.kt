package com.punkpanda.mystudyguide

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.punkpanda.mystudyguide.models.Flashcard // Import your Flashcard class


// In QuizActivity.kt

class QuizActivity : AppCompatActivity() {

    private lateinit var questionTextView: TextView
    private lateinit var answerTextView: TextView
    private lateinit var revealButton: Button
    private lateinit var correctButton: Button
    private lateinit var incorrectButton: Button
    private lateinit var progressTextView: TextView

    private var flashcards: List<Flashcard> = emptyList()
    private var currentIndex: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        // Initialize UI elements
        questionTextView = findViewById(R.id.questionTextView)
        answerTextView = findViewById(R.id.answerTextView)
        revealButton = findViewById(R.id.revealButton)
        correctButton = findViewById(R.id.correctButton)
        incorrectButton = findViewById(R.id.incorrectButton)
        progressTextView = findViewById(R.id.progressTextView)

        // Load your flashcards from a data source
        flashcards = loadFlashcards() // Replace with your data loading logic

        // Display the first flashcard
        displayFlashcard(currentIndex)

        // Set click listeners for buttons
        revealButton.setOnClickListener {
            revealAnswer()
        }

        correctButton.setOnClickListener {
            markCorrect()
        }

        incorrectButton.setOnClickListener {
            markIncorrect()
        }
    }

    private fun loadFlashcards(): List<Flashcard> {
        // Load and return your flashcards from a data source (e.g., database)
        // Example: return flashcardRepository.getAllFlashcards()
        // Make sure to handle data loading and error cases
        return emptyList() // Replace with your actual data loading logic
    }

    private fun displayFlashcard(index: Int) {
        if (index < flashcards.size) {
            val flashcard = flashcards[index]
            questionTextView.text = flashcard.question
            answerTextView.text = flashcard.answer
            answerTextView.visibility = View.GONE
            revealButton.isEnabled = true
            progressTextView.text = "Progress: ${index + 1}/${flashcards.size}"
        } else {
            // All flashcards have been shown
            // You can handle the end of the quiz here
            // Optionally, you can navigate back to the main activity or perform other actions
            finish()
        }
    }

    private fun revealAnswer() {
        answerTextView.visibility = View.VISIBLE
        revealButton.isEnabled = false
    }

    private fun markCorrect() {
        // Handle marking the flashcard as correct
        // Optionally, you can track user's score
        currentIndex++
        displayFlashcard(currentIndex)
    }

    private fun markIncorrect() {
        // Handle marking the flashcard as incorrect
        currentIndex++
        displayFlashcard(currentIndex)
    }
}
