package com.example.flashcard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog

class AddCardActivity : AppCompatActivity() {
    val returnToMain = findViewById<ImageView>(R.id.cancel)
    val save = findViewById<ImageView>(R.id.download)
    val question = findViewById<EditText>(R.id.question)
    val reponse = findViewById<EditText>(R.id.rep)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_card)



        returnToMain.setOnClickListener() {
            val changeToMain = Intent(this, MainActivity::class.java)
            startActivity(changeToMain)
        }

        save.setOnClickListener(){
              val donnees1 = question.text.toString()
              val donnees2 = reponse.text.toString()
            getAndShowQuestion(donnees1,donnees2)
            }

        }
    private  fun getAndShowQuestion(data1: String, data2: String){
        val intent = Intent(this,MainActivity::class.java)
        intent.putExtra("donnees",data1)
        intent.putExtra("donnees2",data2)
        startActivity(intent)
    }

    private fun verifyData(data1: String, data2: String){
        while(data1 =="" && data2 ==""){
            if(data1 ==""){
                val builder = AlertDialog.Builder(this)
                builder.setTitle("error")
                builder.setMessage("Vous devez remplir le champ question")
                builder.show()
            }
            else if(data2 ==""){
                val builder2 = AlertDialog.Builder(this)
                builder2.setTitle("Error")
                builder2.setMessage("Vous devez remplir le champ reponse")
                builder2.show()
            }
        }
    }

    }



