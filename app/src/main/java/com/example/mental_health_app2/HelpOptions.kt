package com.example.mental_health_app2
import android.content.ContentValues
import android.content.Intent
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class HelpOptions : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help_options)
        //val text = findViewById<TextView>(R.id.SadV)
        val extras = intent.extras
        val sliderValue = extras?.getFloat("sliderValue")
        val option = 13
        var MyHelper = DBHelper(applicationContext)
        var db = MyHelper.readableDatabase
        val cal = Calendar.getInstance()
        val doy = cal[Calendar.DAY_OF_YEAR]
        var cv = MyHelper.makeCv(sliderValue!!,1,"None")
        var tempRowNumber= MyHelper.FindRow(doy)

            cv.put("DAY",doy)
            db.insert("USERHAPPINESS",null,cv)





        val Back = findViewById<Button>(R.id.SadBack)
        Back?.setOnClickListener() {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }


        fun SafeDeleteStr(arr: MutableList<String>, arg: String) {
            if (arr.size > 1) {
                arr.remove(arg)
            }
        }

        fun outF(feel: Float) {
            val arr = mutableListOf(0.1,0.2,0.2,0.3,0.3,0.4,0.4,0.5,0.6,0.7,0.8,0.9,1.0,1.1,1.2,1.3,1.4,1.5,1.6,1.7,1.8,1.9,2.0,2.1,2.2,2.3,2.4,2.5,2.6,2.7,2.8,2.9,3.0,3.1,3.2,3.3,3.4,3.5,3.6,3.7,3.8,3.9,4.0,4.1,4.2,4.3,4.4,4.5,4.6,4.7,4.8,4.9,5.0)
            val arrwords = mutableListOf(
                "Remember to go to sleep on time, don't stay up.",
                "Make sure to eat something to keep you going today.",
                "This is not just another day, but rather another chance to make your dreams come true.",
                "Go read some good news!",
                "Look through a album (digital or paper) to remember fun times!",
                "Take a shower to take your mind off things.",
                "Achieve a mental victory today (something simple is fine).",
                "Are your bad days piling up? Try and find a bigger root problem that needs to be solved first.",
                "Find the root problem troubling you, deal with it or forget about it, and then move on. Eliminate blanket statements that cloud your mind.",
                "Pep talk yourself out of the rut you're in, and don't kick yourself unfairly for insignificant mistakes.",
                "Change the scenery! (a park, car, open cafe)",
                "Do some breathing exercises!",
                "Take a break, sit down.",
                "Watch your screen time!",
                "Make a simple to do list, such as to get some fresh air, eat properly, or take a shower.",
                "Write out a list of things bothering you, scratch out the things you can’t control, and then focus on and accomplish the things you can control.",
                "Go on a relaxing long drive or walk.",
                "Vent to someone or a journal.",
                "Go get yourself something nice, but not necessarily expensive.",
                "Go do something fun, such as a movie or museum!",
                "Go do something relaxing, such as a massage, pedicure, or facial!",
                "If you are stuck on something, try finding a long term solution, even if it takes more effort to accomplish.",
                "Laugh!",
                "Be grateful.",
                "Take a moment to control your breath and relax.",
                "Stretch, and remind yourself to get up every now and then.",
                "Go to a yoga or meditation class!",
                "Get a plant!",
                "Talk to some of your family or close friends.",
                "Go eat out, or make something if cooking is a thing you like.",
                "Donate to a shelter, and look at cute animals while you're there!",
                "Help others out.",
                "Listen to some relaxing music.",
                "Do some simple exercises (jog, walk, push-ups, sit-ups, squats, jumping jacks, lunges).",
                "Play a card or board game!",
                "Reflect on the good things you've done today, keep it up!",
                "Remember to set realistic expectations, you're doing fine!",
                "Identify some opportunities to take advantage of in the future.",
                "Take away negative thoughts and replace them with postiive ones, positive thoughts attract positive things.",
                "Drink some water!",
                "Leave a kind note for someone.",
                "Compliment someone else.",
                "Do someone's chores or a little thing for them, it will make a big impact!",
                "Pay for the person behind you!",
                "Keep it up, have fun today!",
                "You got this!",
                "Have a great day!",
                "Make today amazing.",
                "You have to be consistent to be successful, everything is possible.",
                "Remember to hydrate.",
                "Remember to say thank you.",
                "Talk to someone you haven't in a while.",
                "Ask someone how you can help.",
                "Give someone money or supplies to someone to revisit or start a new hobby."

            )
            val templist: MutableList<Double> = mutableListOf()
            val templist1: MutableList<String> = mutableListOf()
            for ((i, e) in arr.withIndex()) {
                val specify = 0.5

                val help1 = feel - specify
                val help2 = specify + feel
                if (help1 < e) {
                    if (e < help2) {
                        templist.add(e)
                        templist1.add(arrwords.elementAt(i))


                    }


                }

            }


            val option1: MutableList<String> = mutableListOf()
            option1.add(templist1.random())
            SafeDeleteStr(templist1, option1[0])


            option1.add(templist1.random())
            SafeDeleteStr(templist1, option1[1])



            option1.add(templist1.random())
            SafeDeleteStr(templist1, option1[2])



            var Option1Button = findViewById<Button>(R.id.hi)
            Option1Button?.setOnClickListener() {
                val Options = option1[0]
                val OptionsIndex= arrwords.indexOf(option1[0])
                val intent = Intent(this, com.example.mental_health_app2.option1::class.java)
                intent.putExtra("Options", Options)
                intent.putExtra("happy", sliderValue)
                intent.putExtra("DOY", doy)
                intent.putExtra("OpIndex", OptionsIndex)

                startActivity(intent)
                finish()
            }

            var Option2Button = findViewById<Button>(R.id.option2button)
            Option2Button?.setOnClickListener() {
                val Options = option1[1]
                val OptionsIndex= arrwords.indexOf(option1[1])
                val intent = Intent(this, com.example.mental_health_app2.option1::class.java)
                intent.putExtra("Options", Options)
                intent.putExtra("happy", sliderValue)
                intent.putExtra("DOY", doy)
                intent.putExtra("OpIndex", OptionsIndex)
                startActivity(intent)
                finish()
            }

            var Option3Button = findViewById<Button>(R.id.Option3button)
            Option3Button?.setOnClickListener() {
                val Options = option1[2]
                val OptionsIndex= arrwords.indexOf(option1[2])
                val intent = Intent(this, com.example.mental_health_app2.option1::class.java)
                intent.putExtra("Options", Options)
                intent.putExtra("happy", sliderValue)
                intent.putExtra("DOY", doy)
                intent.putExtra("OpIndex", OptionsIndex)
                startActivity(intent)
                finish()
            }
                Option1Button.setText(option1[0])
                Option2Button.setText(option1[1])
                Option3Button.setText(option1[2])


            }
            if (sliderValue != null) {
                outF(sliderValue)
            }


        }

    }