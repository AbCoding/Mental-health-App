package com.example.mental_health_app2
import android.content.Intent


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.SeekBar
import com.google.android.material.slider.Slider

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val SettingButton = findViewById<ImageButton>(R.id.settingsButton)
        SettingButton?.setOnClickListener(){
            val intent= Intent(this,settingspage::class.java)
            startActivity(intent)


        }
        val TrendButton = findViewById<ImageButton>(R.id.TrendButton)
        TrendButton?.setOnClickListener(){
            val intent= Intent(this,TrendsActivity::class.java)
            startActivity(intent)
            finish()

        }
        val DiaryButton = findViewById<ImageButton>(R.id.Dbutton)
        DiaryButton?.setOnClickListener(){
            val intent= Intent(this,option1::class.java)
            startActivity(intent)
            finish()

        }
        val SadButton = findViewById<Button>(R.id.Sad1Button)
        val slider= findViewById<Slider>(R.id.HappySlider)
        SadButton?.setOnClickListener(){
            val SliderValue= slider.value
            val intent= Intent(this,HelpOptions::class.java)
            intent.putExtra("sliderValue",SliderValue);
            println(SliderValue)
            startActivity(intent)
            finish()


        }




        }

        }

