package com.example.mental_health_app2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class settingspage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settingspage)
        //val et_text = findViewById<EditText>(R.id.et_text)
        //val tv_text = findViewById<TextView>(R.id.tv_text)
        val DarkMode = findViewById<CheckBox>(R.id.DarkMode)
        val audio = findViewById<CheckBox>(R.id.muteaudio)
        val notificationz = findViewById<CheckBox>(R.id.Dailynotifications)

        loadData(DarkMode,audio,notificationz)

        val bt_button = findViewById<Button>(R.id.bt_button)
        bt_button.setOnClickListener{
            saveData(DarkMode,audio,notificationz)

        }
        val Back = findViewById<Button>(R.id.back_button)
        Back?.setOnClickListener() {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()}


    }


    private fun saveData(DarkMode:CheckBox,audio:CheckBox,notificationz:CheckBox) {
        //val insertedText = et_text.text.toString()
        //tv_text.text = insertedText

        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.apply{
            //putString("STRING_KEY",insertedText)
            putBoolean("BOOLEAN_KEY",DarkMode.isChecked)
            putBoolean("BOOLEAN_KEY1",audio.isChecked)
            putBoolean("BOOLEAN_KEY2",notificationz.isChecked)
        }.apply()

        Toast.makeText(this,"Data saved",Toast.LENGTH_SHORT).show()

    }

    private fun loadData(DarkMode: CheckBox,audio:CheckBox,notificationz:CheckBox){
        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        //val savedString = sharedPreferences.getString("STRING_KEY", null)
        val savedBoolean = sharedPreferences.getBoolean("BOOLEAN_KEY",false)
        val savedBoolean1 = sharedPreferences.getBoolean("BOOLEAN_KEY1",false)
        val savedBoolean2 = sharedPreferences.getBoolean("BOOLEAN_KEY2",false)

        //tv_text.text = savedString
        DarkMode.isChecked = savedBoolean
        audio.isChecked = savedBoolean1
        notificationz.isChecked = savedBoolean2
    }

}