package com.example.quizapp.model

data class QuestionModel(
    val question: String,
    val options: List<String>,
    val answer: String,
    val userAnswer: String
)
