package com.example.quizapp.utils

object ColorPicker {
    val colors = arrayOf(
        "#BD6565",
        "#7C65BD",
        "#8B24B1",
        "#B18424",
        "#A10427",
    )
    var currentColorIndex = 0
    fun getColor(): String{
        currentColorIndex = (currentColorIndex + 1) % colors.size
        return colors[currentColorIndex]
    }

}