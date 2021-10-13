package com.example.mental_health_app2
import android.content.Intent


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val SettingButton = findViewById<Button>(R.id.settingsButton)
        SettingButton?.setOnClickListener(){
            val intent= Intent(this,SettingsActivity::class.java)
            startActivity(intent)


        }
        val TrendButton = findViewById<Button>(R.id.TrendButton)
        TrendButton?.setOnClickListener(){
            val intent= Intent(this,TrendsActivity::class.java)
            startActivity(intent)
            finish()

        }
        val SadButton = findViewById<Button>(R.id.Sad1Button)
        SadButton?.setOnClickListener(){
            val intent= Intent(this,HelpOptions::class.java)
            startActivity(intent)
            finish()

        }





        }

        }

