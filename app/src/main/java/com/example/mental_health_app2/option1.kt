package com.example.mental_health_app2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout

class option1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_option1)
        val option1text = findViewById<TextView>(R.id.option1text)
        val extras = intent.extras
        val Options = extras?.getString("Options")
        option1text.setText(Options)



        val Back = findViewById<Button>(R.id.Option1Back)
        Back?.setOnClickListener() {
            val intent = Intent(this, HelpOptions::class.java)
            startActivity(intent)
            finish()


    }

}

}
