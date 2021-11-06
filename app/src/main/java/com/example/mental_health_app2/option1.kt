package com.example.mental_health_app2

import android.content.Intent
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class option1 : AppCompatActivity() {
    fun doyFromDt(dt: String): Int {
        var mnth=0
        var dy=0
        var tmpchar= dt.get(0).digitToInt()

        mnth+=tmpchar*10
        tmpchar= dt.get(1).digitToInt()
        mnth+=tmpchar
        tmpchar= dt.get(3).digitToInt()
        dy+=tmpchar*10

        tmpchar= dt.get(4).digitToInt()
        dy+=tmpchar
        dy+= (mnth-1)*30
        dy=dy.toInt()
        return dy

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_option1)

        val cal = Calendar.getInstance()
        val doy = cal[Calendar.DAY_OF_YEAR]




        var MyHelper = DBHelper(applicationContext)
        var db = MyHelper.readableDatabase
        var rs= db.rawQuery("SELECT * FROM USERHAPPINESS",null)
        rs.moveToLast()
        val happiness= rs.getFloat(1)
        val Option= rs.getInt(2)







        val Back = findViewById<Button>(R.id.Option1Back)
        Back?.setOnClickListener() {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()




    }
        val Safe= findViewById<Button>(R.id.safebutton)
        val Diarytext= findViewById<TextInputEditText>(R.id.diary)
        Safe?.setOnClickListener(){
            var cv= MyHelper.makeCv(happiness,Option,Diarytext.text.toString())
            MyHelper.UpdateByDay(doy!!,cv)

        }
        val View= findViewById<Button>(R.id.viewbutton)
        val ViewText=findViewById<TextView>(R.id.diarytext)
        val datetext=findViewById<EditText>(R.id.dateText)
        View?.setOnClickListener(){
           val dt= datetext.text
            val day=doyFromDt(dt.toString())
            println(day)
            rs.moveToPosition(day!!)
           val dtext= rs.getString(3)
            ViewText.text=dtext

        }

}

}
