package com.example.mental_health_app2
import android.content.ContentValues
import android.content.Intent
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class HelpOptions : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help_options)
        val text= findViewById<TextView>(R.id.SadV)
        val extras = intent.extras
        val sliderValue= extras?.getFloat("sliderValue")
        val option=13
        var MyHelper= DBHelper(applicationContext)
        var db= MyHelper.readableDatabase
        val cal = Calendar.getInstance()
        val doy = cal[Calendar.DAY_OF_YEAR]
        var cv= ContentValues()
        cv.put("DAY",doy )
        cv.put("HAPPINESS",sliderValue )
        cv.put("OPTION",option )
        cv.put("DIARY","hellwewewo" )
        db.insert("USERHAPPINESS",null,cv)
        val Back = findViewById<Button>(R.id.SadBack)
        Back?.setOnClickListener(){
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}