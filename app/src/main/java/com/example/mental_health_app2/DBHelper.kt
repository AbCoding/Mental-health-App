package com.example.mental_health_app2
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns

class DBHelper(context: Context) : SQLiteOpenHelper(context,"UserHappiness",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE USERHAPPINESS(DAY INTEGER PRIMARY KEY,HAPPINESS REAL,OPTION INTEGER, DIARY TEXT )")
        db?.execSQL("INSERT INTO USERHAPPINESS(DAY, HAPPINESS, OPTION, DIARY) VALUES(10,1.12,12,'hello')")
        db?.execSQL("INSERT INTO USERHAPPINESS(DAY, HAPPINESS, OPTION, DIARY) VALUES(90,3.12,32,'hoo3131llo')")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

    fun UpdateByDay(day: Int, cv: ContentValues) {
        val whereclause = "DAY=?"
        val whereargs = arrayOf(day.toString())
        this.writableDatabase.update(TABLE_ID,cv,whereclause,whereargs)
    }
    fun makeCv(Happy: Float, Opt: Int, Diary: String): ContentValues {
        var cv= ContentValues()

        cv.put(HAPPY_COL, Happy)
        cv.put(OPTION_COL, Opt)
        cv.put(DIARY_COL, Diary)
        return cv
    }
    fun FindRow(day: Int){
        this.writableDatabase.rawQuery("SELECT*FROM USERHAPPINESS WHERE DAY=$day",null)
    }
    companion object{
        val TABLE_ID= "USERHAPPINESS"
        val DAY_COL= "DAY"
        val HAPPY_COL="HAPPINESS"
        val OPTION_COL="OPTION"
        val DIARY_COL= "DIARY"
    }
}