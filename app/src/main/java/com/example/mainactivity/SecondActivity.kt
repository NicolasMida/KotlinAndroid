package com.example.mainactivity

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)

        val nextButton = findViewById<TextView>(R.id.nextButton)
        val nomTextView = findViewById<TextView>(R.id.nomTextView)
        val professionTextView = findViewById<TextView>(R.id.professionTextView)
        val societeTextView = findViewById<TextView>(R.id.societeTextView)


        val nom = intent.getStringExtra("nom")
        val profession = intent.getStringExtra("profession")
        val societe = intent.getStringExtra("societe")


        nomTextView.text = "Nom: $nom"
        professionTextView.text = "Profession: $profession"
        societeTextView.text = "Société: $societe"

        nextButton.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java).apply {
                putExtra("nom", nom)
                putExtra("profession", profession)
                putExtra("societe", societe)
            }
            startActivity(intent)
        }
    }
}