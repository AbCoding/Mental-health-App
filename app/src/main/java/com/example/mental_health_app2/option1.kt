package com.example.mental_health_app2

import android.content.Intent
import android.icu.util.Calendar
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
        val OptionIndex= extras?.getInt("OpIndex")
        val Options = extras?.getString("Options")
        val sliderValue = extras?.getFloat("happy")
        val doy = extras?.getInt("DOY")
        option1text.setText(Options)
        var MyHelper = DBHelper(applicationContext)
        var db = MyHelper.readableDatabase
        var cv = MyHelper.makeCv(sliderValue!!, OptionIndex!!,"None")



        MyHelper.UpdateByDay(doy!!,cv)
        println(12)


        val Back = findViewById<Button>(R.id.Option1Back)
        Back?.setOnClickListener() {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()




    }

}

}
