package com.punkpanda.mystudyguide

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.punkpanda.mystudyguide.models.Flashcard

class FlashcardAdapter(private val flashcards: List<Flashcard>) :
    RecyclerView.Adapter<FlashcardAdapter.FlashcardViewHolder>() {

    inner class FlashcardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val questionTextView: TextView = itemView.findViewById(R.id.questionTextView)
        val answerTextView: TextView = itemView.findViewById(R.id.answerTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlashcardViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.flashcard_item, parent, false)
        return FlashcardViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FlashcardViewHolder, position: Int) {
        val currentFlashcard = flashcards[position]
        holder.questionTextView.text = currentFlashcard.question
        holder.answerTextView.text = currentFlashcard.answer
    }

    override fun getItemCount() = flashcards.size
}
