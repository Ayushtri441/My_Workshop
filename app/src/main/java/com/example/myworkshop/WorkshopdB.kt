package com.example.myworkshop

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class WorkshopdB(context: Context?): SQLiteOpenHelper(context,"Workshopdb",null,1) {
    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL("create table Workshopdb (Coursename TEXT primary key ,Info TEXT,Rating TEXT)")
    }
    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL("drop table if exists Workshopdb");
    }

    fun insertdata(Coursename: String,Info : String ,Rating :String): Boolean {
        val p0 = this.writableDatabase
        val cv = ContentValues()
        cv.put("Coursename", Coursename)
        cv.put("Info", Info)
        cv.put("Rating", Rating)
        val result = p0.insert("Workshopsdb", null, cv);
        if (result == -1.toLong()) {
            return false
        }
        return true

    }
    fun getAllCourses() : ArrayList<Model>{
        val list  : ArrayList<Model> = ArrayList()
        val query = "SELECT * FROM Workshopdb  "
        val db = this.readableDatabase
        val cursor : Cursor?
        try{
            cursor= db.rawQuery(query,null)
        }
        catch (e: java.lang.Exception){
            db.execSQL(query)
            e.printStackTrace()
            return ArrayList()
        }
        var course :String
        var info :String
        var rate : String
        if(cursor.moveToFirst()){
            do {
                course = cursor.getString(cursor.getColumnIndexOrThrow("Coursename"))
                info = cursor.getString(cursor.getColumnIndexOrThrow("Info"))
                rate = cursor.getString(cursor.getColumnIndexOrThrow("Rating"))
            }while (cursor.moveToNext())
           val std = Model(name = course, info = info, rating = rate)
            list.add(std)
        }
        return list

    }

}