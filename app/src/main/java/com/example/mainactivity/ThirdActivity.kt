package com.example.mainactivity

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_third)

        val nomTextView = findViewById<TextView>(R.id.nomTextView)
        val professionTextView = findViewById<TextView>(R.id.professionTextView)
        val societeTextView = findViewById<TextView>(R.id.societeTextView)
        val imageView = findViewById<ImageView>(R.id.badgeImageView)

        val nom = intent.getStringExtra("nom")
        val profession = intent.getStringExtra("profession")
        val societe = intent.getStringExtra("societe")

        // this is a "default" picture of the user
        imageView.setImageResource(R.drawable.default_badge_image)

        nomTextView.text = nom
        professionTextView.text = profession
        societeTextView.text = societe

    }
}