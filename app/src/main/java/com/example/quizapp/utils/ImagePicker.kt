package com.example.quizapp.utils

import com.example.quizapp.R

object ImagePicker {
    val images = arrayOf(
        R.drawable.sample_1,
        R.drawable.sample_2,
        R.drawable.sample_3,
        R.drawable.sample_4,
        R.drawable.sample_5,
        R.drawable.sample_6,
        R.drawable.sample_7,
        R.drawable.sample_8,
        R.drawable.sample_9,
        R.drawable.sample_10
    )
    var currentImageIndex = 0
    fun getImage(): Int {
        currentImageIndex =  (currentImageIndex +1) % images.size
        return images[currentImageIndex]
    }
}