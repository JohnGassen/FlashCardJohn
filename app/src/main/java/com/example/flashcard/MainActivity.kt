package com.example.flashcard

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.flashCard_question)
        val textAnswer = findViewById<TextView>(R.id.answer)
        val ajout = findViewById<ImageView>(R.id.addView)

        textView.setOnClickListener() {
            if (textAnswer.visibility == View.GONE) {
                textAnswer.visibility = View.VISIBLE
                textView.visibility = View.GONE
            }
        }
        textAnswer.setOnClickListener() {
            textAnswer.visibility = View.GONE
            textView.visibility = View.VISIBLE
        }

        ajout.setOnClickListener(){
            val changeToAdd = Intent(this,AddCardActivity::class.java)
            startActivity(changeToAdd)
        }

        val receivedData = intent.getStringExtra("data")
        val receivedData2 = intent.getStringExtra(("data2"))
        if(receivedData != null && receivedData2 != null){
            textView.text = receivedData
            Toast.makeText(this,receivedData, Toast.LENGTH_SHORT).show()
            textAnswer.text = receivedData2
                Toast.makeText(this,receivedData2, Toast.LENGTH_SHORT).show()
        }


    }
}