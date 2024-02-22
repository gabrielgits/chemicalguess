package com.example.helloword

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val chemicalList = mutableListOf<String>()

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonAdd = findViewById<Button>(R.id.buttonAdd)
        val buttonGuess = findViewById<Button>(R.id.buttonGuess)

        val editTextName = findViewById<EditText>(R.id.editTextName)
        val editTextGuess = findViewById<EditText>(R.id.editTextGuess)
        val textViewMsn = findViewById<TextView>(R.id.textViewInfo)


        buttonAdd.setOnClickListener {
            if (checkIfChemicalExist(editTextName.text.toString())) {
                textViewMsn.text = "Chemical ${editTextName.text} is already available"
            } else {
                chemicalList.add(editTextName.text.toString())
                textViewMsn.text = "Chemical ${editTextName.text} added"
            }
            editTextName.text.clear()
        }

        buttonGuess.setOnClickListener {
            val randomChemical = chemicalList.random()
            if (randomChemical == editTextGuess.text.toString()) {
                textViewMsn.text = "Congratulation! You guessed it right.\nIt was $randomChemical"

            } else {
                textViewMsn.text = "Sorry, you guessed it wrong.\nThe correct answer was $randomChemical"
            }
            editTextGuess.text.clear()

        }

    }



    private fun checkIfChemicalExist(chemical: String): Boolean {
        return chemicalList.contains(chemical)
    }
}

