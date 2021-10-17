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
        val Option1Button = findViewById<Button>(R.id.Option1Button)
        Option1Button?.setOnClickListener() {
            val intent = Intent(this, option1::class.java)
            startActivity(intent)
            finish()
        }


            fun outF(feel: Float) {
                val arr = mutableListOf(0.3,1.2,3.0,3.1,3.2,3.8)
                val arrwords = mutableListOf("lool sad dafuh","ugly ass","suck cock","cock csuc","22321","oefuboaubefoabe")
                val templist: MutableList<Double> = mutableListOf()
                val templist1: MutableList<String> = mutableListOf()
                for ((i, e) in arr.withIndex()) {
                    val specify = 0.5

                    val help1 = feel-specify
                    val help2 = specify+feel
                    if (help1<e) {
                        if (e<help2){
                            templist.add(e)
                            templist1.add(arrwords.elementAt(i))


                        }


                    }

                }
                val option1: MutableList<String> = mutableListOf()
                option1.add(templist1.random())
                templist1.remove(option1[0])
                println(option1)
                val option2: MutableList<String> = mutableListOf()
                option2.add(templist1.random())
                templist1.remove(option2[0])
                println(option2)
                val option3: MutableList<String> = mutableListOf()
                option3.add(templist1.random())
                templist1.remove(option3[0])
                println(option3)


            }

        if (sliderValue != null) {
            outF(sliderValue)
        }

        }

    }
