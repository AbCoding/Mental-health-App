package com.example.mental_health_app2
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
class DBHelper(context: Context) : SQLiteOpenHelper(context,"UserHappiness",null,1){
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE USERHAPPINESS(ENTRY INTEGER PRIMARY KEY AUTOINCREMENT, DAY INTEGER,HAPPINESS REAL,OPTION INTEGER, DIARY TEXT )")
        db?.execSQL("INSERT INTO USERHAPPINESS(DAY, HAPPINESS, OPTION, DIARY) VALUES(10,1.12,12,'hello')")
        db?.execSQL("INSERT INTO USERHAPPINESS(DAY, HAPPINESS, OPTION, DIARY) VALUES(90,3.12,32,'hoo3131llo')")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }
}