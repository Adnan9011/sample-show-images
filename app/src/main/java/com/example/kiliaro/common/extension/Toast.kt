package com.example.kiliaro.common

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

fun AppCompatActivity.shortToast(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}

fun AppCompatActivity.longToast(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_LONG).show()
}
