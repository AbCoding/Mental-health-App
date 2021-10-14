package com.example.mental_health_app2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView

class HelpOptions : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help_options)
        val text= findViewById<TextView>(R.id.SadV)
        val extras = intent.extras
        val sliderValue= extras?.getFloat("sliderValue")

        text.setText(sliderValue.toString())
        val Back = findViewById<Button>(R.id.SadBack)
        Back?.setOnClickListener(){
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}