package com.example.myworkshop

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class WorkshopdB(context: Context?): SQLiteOpenHelper(context,"Workshop",null,1) {
    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL("create table Workshop (coursename TEXT  ,info TEXT,rating TEXT,user TEXT)")
    }
    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL("drop table if exists Workshop");
    }

    fun insertdata(coursename: String,info : String ,rating :String,user : String): Boolean {
        val p0 = this.writableDatabase
        val cv = ContentValues()
        cv.put("coursename", coursename)
        cv.put("info", info)
        cv.put("rating", rating)
        cv.put("user",user)
        val result = p0.insert("Workshop", null, cv);
        if (result == -1.toLong()) {
            return false
        }
        return true

    }
    fun getAllCourses(user : String) : MutableList<String>{
        var l  = mutableListOf<String>()
        val query = "SELECT * FROM Workshop WHERE user ='$user' "
        val db = this.readableDatabase
        val cursor : Cursor?
        try{
            cursor= db.rawQuery(query,null)
        }
        catch (e: java.lang.Exception){
            db.execSQL(query)
            e.printStackTrace()
            return l
        }
        var course :String
        var info :String
        var rate : String
        if(cursor.moveToFirst()){
            do {
                course = cursor.getString(cursor.getColumnIndexOrThrow("coursename"))
                info = cursor.getString(cursor.getColumnIndexOrThrow("info"))
                rate = cursor.getString(cursor.getColumnIndexOrThrow("rating"))
                course = course +" ("+ rate+") "+info
                l.add(course)
                course=""
            }while (cursor.moveToNext())

        }
        return l

    }

}