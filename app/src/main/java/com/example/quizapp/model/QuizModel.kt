package com.example.quizapp.model

data class QuizModel(
    val id: String,
    val title: String,
    val questions: MutableMap<String, QuestionModel> = mutableMapOf()
)
