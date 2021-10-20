package com.example.mental_health_app2
import android.content.ContentValues
import android.content.Intent
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class HelpOptions : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help_options)
        val text= findViewById<TextView>(R.id.SadV)
        val extras = intent.extras
        val sliderValue= extras?.getFloat("sliderValue")
        val option=156
        var MyHelper= DBHelper(applicationContext)
        var db= MyHelper.readableDatabase
        val cal = Calendar.getInstance()
        val doy = cal[Calendar.DAY_OF_YEAR]
        var cv = MyHelper.makeCv(sliderValue!!,option,"rigga")
        var tempRowNumber= MyHelper.FindRow(doy)
        if( tempRowNumber == null){
            cv.put("DAY",doy)
            db.insert("USERHAPPINESS",null,cv)
        }
        else{
            MyHelper.UpdateByDay(doy,cv)
        }

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


            fun SafeDeleteStr(arr: MutableList<String>,arg:String){
                if(arr.size > 1){
                    arr.remove(arg)
                }
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
                SafeDeleteStr(templist1,option1[0])


                option1.add(templist1.random())
                SafeDeleteStr(templist1,option1[1])


                option1.add(templist1.random())
                SafeDeleteStr(templist1,option1[2])
                Option1Button.setText(option1[0])


            }

        if (sliderValue != null) {
            outF(sliderValue)
        }


        }

    }
