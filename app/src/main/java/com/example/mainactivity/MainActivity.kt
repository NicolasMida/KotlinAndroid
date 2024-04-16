package com.example.mainactivity

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var nomEditText: EditText
    private lateinit var professionEditText: EditText
    private lateinit var societeEditText: EditText
    private lateinit var submitButton: Button
    private lateinit var errorTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        enableEdgeToEdge()

        // Get views
        submitButton = findViewById<Button>(R.id.submitButton)
        nomEditText = findViewById<EditText>(R.id.nomEditText)
        professionEditText = findViewById<EditText>(R.id.professionEditText)
        societeEditText = findViewById<EditText>(R.id.societeEditText)
        errorTextView = findViewById<TextView>(R.id.errorTextView)


        // Listeners
        nomEditText.addTextChangedListener(textWatcher)
        professionEditText.addTextChangedListener(textWatcher)
        societeEditText.addTextChangedListener(textWatcher)

        submitButton.isEnabled = false


        submitButton.setOnClickListener {
            val nom = nomEditText.text.toString()
            val profession = professionEditText.text.toString()
            val societe = societeEditText.text.toString()
            val intent = Intent(this, SecondActivity::class.java).apply {
                putExtra("nom", nom)
                putExtra("profession", profession)
                putExtra("societe", societe)
            }
            startActivity(intent)
        }
    }

    private val textWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

        override fun afterTextChanged(s: Editable?) {
            val containsSpecialCharacter = nomEditText.text.toString().contains("[^a-zA-Z]".toRegex())
                    || professionEditText.text.toString().contains("[^a-zA-Z]".toRegex())
                    || societeEditText.text.toString().contains("[^a-zA-Z]".toRegex())

            submitButton.isEnabled = !containsSpecialCharacter

            if (containsSpecialCharacter) {
                errorTextView.text = "Veuillez saisir uniquement des lettres dans les champs."
                errorTextView.visibility = View.VISIBLE
            } else {
                errorTextView.visibility = View.GONE
            }
        }
    }
}