package com.example.quizapp.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.R
import com.example.quizapp.model.QuizModel
import com.example.quizapp.utils.ColorPicker
import com.example.quizapp.utils.ImagePicker

class QuizAdapter(val context: Context, val quizzes: List<QuizModel>) :
    RecyclerView.Adapter<QuizAdapter.QuizViewHolder>() {
    inner class QuizViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var textViewTitle: TextView = itemView.findViewById(R.id.cardTextView)
        var imgView: ImageView = itemView.findViewById(R.id.cardImage)
        var cardContainer: CardView = itemView.findViewById(R.id.cardContainer)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuizViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.card_sample, parent, false)
        return QuizViewHolder(view)
    }

    override fun getItemCount(): Int {
       return quizzes.size
    }

    override fun onBindViewHolder(holder: QuizViewHolder, position: Int) {
        holder.textViewTitle.text = quizzes[position].title
        holder.cardContainer.setCardBackgroundColor(Color.parseColor(ColorPicker.getColor()))
        holder.imgView.setImageResource(ImagePicker.getImage())
        holder.itemView.setOnClickListener{
            Toast.makeText(context, quizzes[position].title, Toast.LENGTH_SHORT).show()
        }
    }
}