package com.example.mental_health_app2

import android.content.Intent
import android.graphics.Color.green
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.components.AxisBase

import com.github.mikephil.charting.formatter.IAxisValueFormatter
import java.util.*
import kotlin.collections.ArrayList


class TrendsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trends)
        val backButton= findViewById<Button>(R.id.TrendBack)
        var RdGroup= findViewById<RadioGroup>(R.id.radioGroup)
        var MyHelper= DBHelper(applicationContext)
        var db= MyHelper.readableDatabase
        var rs = db.rawQuery("SELECT * FROM USERHAPPINESS",null)
        var lineChart= findViewById<LineChart>(R.id.LineChart1)
        ConfigureLineChart(lineChart, "Weekly View")

        RdGroup.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId ->
            // checkedId is the RadioButton selected
            val rb = findViewById<View>(checkedId) as RadioButton
            println(rb.text)
           ConfigureLineChart(lineChart, rb.text.toString())




        })

        backButton?.setOnClickListener {
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun ConfigureLineChart(lc: LineChart,Viewtype: String){
        var sm=0F
        // Sets the Default Parameters for the chart
        val desc = Description()
        desc.text = ""
        desc.textSize = 28F
        lc.description = desc
        lc.setTouchEnabled(false)
        lc.xAxis.isEnabled=true
        lc.axisRight.isEnabled=false
        lc.axisLeft.setDrawLabels(true)
        lc.legend.isEnabled=false
        lc.axisLeft.axisMinimum=-0.5F
        lc.axisLeft.axisMaximum=5.5F
        lc.axisLeft.setLabelCount(5)
        lc.xAxis.axisMinimum=0.75F
        lc.axisLeft.textSize=20F

        //sets the data vars for the graph
        var LineWidth= 5F
        var lineEntry= ArrayList<Entry>()
        var xAxis = lc.xAxis
        var xValues= ArrayList<String>()
        var HappinessValueList= ArrayList<Float>()
        var DayList = ArrayList<Float>()
        //sets up Database things
        var MyHelper= DBHelper(applicationContext)
        var db= MyHelper.readableDatabase
        var rs = db.rawQuery("SELECT * FROM USERHAPPINESS",null)
        var smoothness= 10

        // loop to gp across every data thing in the database and write down the output in the array
        rs.moveToFirst()
        while(rs.moveToNext()){
            xValues.add(rs.getInt(1).toString())
           //lineEntry.add(Entry(rs.getFloat(0), rs.getFloat(1).toFloat()))

            HappinessValueList.add((rs.getFloat(1)))
            DayList.add((rs.getFloat(0)))

        }

        val CurrentEntry= (DayList.size-1)

        if (Viewtype=="Yearly View"){

        // year view
        for(i in 1..DayList.size-1){
            var CurrentIndex =  i

            var currentH = HappinessValueList[CurrentIndex]
            sm = (sm+currentH)
            if(i%smoothness ==0) {

                lineEntry.add(Entry(i.toFloat(), (sm/smoothness)))
                sm=0F
            }
        }
            val linedataset= LineDataSet(lineEntry,"Main")
            linedataset.mode=LineDataSet.Mode.CUBIC_BEZIER
            linedataset.lineWidth=LineWidth
            val data= LineData(linedataset)

            data.setDrawValues(false)
            lc.data=data
            xAxis.valueFormatter=YearFormatter()
            lc.setVisibleXRange(0.5F,(DayList.size-1).toFloat())
            lc.xAxis.labelCount=8

            lc.data.setValueTextSize(10F)
            lc.invalidate()

        }
        //month view
        if (Viewtype=="Monthly View"){

        for(i in 1..30){


                var CurrentIndex = CurrentEntry - i
                var currentD = DayList[CurrentIndex] - 1
                var currentH = HappinessValueList[CurrentIndex]
                lineEntry.add(Entry(i.toFloat(), currentH))


        }
            val linedataset= LineDataSet(lineEntry,"Main")
            linedataset.mode=LineDataSet.Mode.STEPPED
            linedataset.lineWidth=LineWidth
            val data= LineData(linedataset)
            data.setDrawValues(false)
            xAxis.valueFormatter=MonthFormatter()
            lc.xAxis.labelCount=29/3
            lc.data=data

            lc.setVisibleXRange(0.5F,29.5F)


            lc.data.setValueTextSize(40F)
            lc.invalidate()
        }
        // week view
            if (Viewtype=="Weekly View") {


                for (i in 1..7) {

                    var CurrentIndex = CurrentEntry - i
                    var currentD= DayList[CurrentIndex] -1
                    var currentH =HappinessValueList[CurrentIndex]
                    lineEntry.add(Entry(i.toFloat(),currentH))


                }
                val linedataset= LineDataSet(lineEntry,"Main")

                val data= LineData(linedataset)
                lc.xAxis.labelCount=6
                linedataset.mode=LineDataSet.Mode.STEPPED
                linedataset.lineWidth=LineWidth

                lc.data=data
                xAxis.valueFormatter=WeekFormatter()
                lc.setVisibleXRange(1F,6.5F)

                lc.data.setValueTextSize(10F)
                lc.invalidate()


            }

    }
    class YearFormatter : ValueFormatter() {
       val months= arrayListOf<String>("January","February","March","April","May","June","July","August","September","October","November","December")
        override fun getAxisLabel(value: Float, axis: AxisBase?): String {
            return months.getOrNull((value/30).toInt()) ?: (value/30).toString()
        }
    }
    class MonthFormatter : ValueFormatter() {

        override fun getAxisLabel(value: Float, axis: AxisBase?): String {
            return value.toString()
        }
    }
    class WeekFormatter : ValueFormatter() {
        val Days= arrayListOf<String>("Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday")
        override fun getAxisLabel(value: Float, axis: AxisBase?): String {
            val cal = Calendar.getInstance()
            val dow = cal[Calendar.DAY_OF_WEEK]
            var v2 = (value +dow-2)%7
            return Days.getOrNull((v2).toInt()) ?: (v2).toString()
        }
    }
}