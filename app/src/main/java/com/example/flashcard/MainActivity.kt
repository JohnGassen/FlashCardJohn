package com.example.flashcard

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.flashCard_question)
        val textAnswer = findViewById<TextView>(R.id.answer)
        val rep1 = findViewById<Button>(R.id.boutonRep1)
        val rep2 = findViewById<Button>(R.id.boutonRep2)
        val rep3 = findViewById<Button>(R.id.boutonRep3)

        textView.setOnClickListener() {
            if (textAnswer.visibility == View.GONE) {
                textAnswer.visibility == View.VISIBLE
                textView.visibility == View.GONE
            }
        }
        textAnswer.setOnClickListener() {
            textAnswer.visibility == View.GONE
            textView.visibility ==View.VISIBLE
        }

        rep1.setOnClickListener() {
            val newColor = Color.parseColor("#FF0000")
            rep1.setBackgroundColor(newColor)
        }
        rep2.setOnClickListener(){
            val newColor = Color.parseColor("#008000")
            rep2.setBackgroundColor(newColor)
        }
        rep3.setOnClickListener(){}
        val newColor = Color.parseColor("#FF0000")
        rep3.setBackgroundColor(newColor)

    }
}