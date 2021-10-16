package com.example.mental_health_app2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class TrendsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trends)
        val backButton= findViewById<Button>(R.id.TrendBack)
        var MyHelper= DBHelper(applicationContext)
        var db= MyHelper.readableDatabase
        var rs = db.rawQuery("SELECT * FROM USERHAPPINESS",null)
        if(rs.moveToNext()){
            Toast.makeText(applicationContext,rs.getString(1), Toast.LENGTH_LONG).show()

        }
        backButton?.setOnClickListener(){
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}