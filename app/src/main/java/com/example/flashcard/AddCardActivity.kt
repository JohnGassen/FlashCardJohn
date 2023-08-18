package com.example.flashcard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog

class AddCardActivity : AppCompatActivity() {
    val returnToMain = findViewById<ImageView>(R.id.cancel)
    val save = findViewById<ImageView>(R.id.download)
    val question = findViewById<EditText>(R.id.question)
    val reponse = findViewById<EditText>(R.id.rep)
    lateinit var flashcardatabase: FlashcardDatabase
    var allFlashcards = mutableListOf<Flashcard>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_card)
        flashcardatabase = FlashcardDatabase(this)
        allFlashcards = flashcardatabase.getAllCards().toMutableList()


        returnToMain.setOnClickListener() {
            val changeToMain = Intent(this, MainActivity::class.java)
            startActivity(changeToMain)
        }

        save.setOnClickListener(){
            getAndShowQuestion(question.toString(),reponse.toString())
            }

        }
    private  fun getAndShowQuestion(data1: String, data2: String){
        val intent = Intent(this,MainActivity::class.java)
        val quest = question.text.toString()
        val rep = reponse.text.toString()
        if(verifyData(quest,rep)){
            val question_ans = Flashcard(quest,rep)
            flashcardatabase.insertCard(question_ans)
            allFlashcards = flashcardatabase.getAllCards().toMutableList()
        }

        intent.putExtra("donnees",data1)
        intent.putExtra("donnees2",data2)
        startActivity(intent)
    }

    private fun verifyData(data1: String, data2: String): Boolean{
       return !(TextUtils.isEmpty(data1) && (TextUtils.isEmpty(data2)))
    }

    }



