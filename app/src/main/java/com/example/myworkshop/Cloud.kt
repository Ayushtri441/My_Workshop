package com.example.myworkshop

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Cloud : AppCompatActivity() {
    lateinit var name : TextView
    lateinit var Info : TextView
    lateinit var rateing : TextView
    lateinit var btn : Button
    lateinit var User : TextView
    lateinit var db : WorkshopdB
    lateinit var stu : DBhelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cloud)
        name = findViewById(R.id.android)
        Info = findViewById(R.id.text)
        rateing = findViewById(R.id.reating)
        btn = findViewById(R.id.btn)
        stu = DBhelper(this)
        db = WorkshopdB(this)
        btn.setOnClickListener{
            val uname = name.text.toString()
            val uinfo = Info.text.toString()
            val urate = rateing.text.toString()
            val savedata = db.insertdata(uname,uinfo,urate)
            if(savedata==true){
                Toast.makeText(this,"Course selected Uscessfully", Toast.LENGTH_LONG).show()
            }
            else {
                Toast.makeText(this,"course Already Selected", Toast.LENGTH_LONG).show()
            }
        }


    }
}