package com.example.flashcard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var flashcardatabase: FlashcardDatabase
    var allFlashcards = mutableListOf<Flashcard>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        flashcardatabase = FlashcardDatabase(this)
        allFlashcards = flashcardatabase.getAllCards().toMutableList()

        val textView = findViewById<TextView>(R.id.flashCard_question)
        val textAnswer = findViewById<TextView>(R.id.answer)
        val ajout = findViewById<ImageView>(R.id.addView)
        val AdvanceQuestion = findViewById<ImageView>(R.id.next)
        val DeleteAnswerQuestion = findViewById<ImageView>(R.id.deleteQuestion)

        AdvanceQuestion.setOnClickListener(){
            val ListQuestion = flashcardatabase.getAllCards()
            if(ListQuestion.isNotEmpty()){
                val randomIndex = Random.nextInt(0,ListQuestion.size)
                val randomQuestion = ListQuestion[randomIndex]
                textView.text = randomQuestion.question
                textAnswer.text = randomQuestion.answer
            }
        }

        DeleteAnswerQuestion.setOnClickListener(){
            var index: Int = 0
            allFlashcards = flashcardatabase.getAllCards().toMutableList()
            for(index in 0.. allFlashcards.size) {
                val questionToDelete = textView.text.toString()
                if (allFlashcards.isNotEmpty()) {

                    flashcardatabase.deleteCard(questionToDelete)
                    textView.text = ""
                    textAnswer.text = ""

                }
            }
            allFlashcards[index--]
        }

        if(allFlashcards.size >0){
            var (question, answer) = allFlashcards[0]
            textView.text = question
            textAnswer.text = answer
        }

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

        val receiveData = intent.getStringExtra("data")
        val receiveData2 = intent.getStringExtra(("data2"))
        if(receiveData != null && receiveData2 != null){
            flashcardatabase.insertCard(Flashcard(receiveData.toString(),receiveData2.toString()))
            allFlashcards = flashcardatabase.getAllCards().toMutableList()
            textView.text = receiveData
            textAnswer.text = receiveData2
        }



    }
}