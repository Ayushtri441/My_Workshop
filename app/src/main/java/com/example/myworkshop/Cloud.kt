package com.example.myworkshop

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.myworkshop.MainActivity.Companion.globalVar
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
        btn.setOnClickListener {
            val uname = name.text.toString()
            val uinfo = Info.text.toString()
            val urate = rateing.text.toString()

            if (globalVar.equals("")) {
                Toast.makeText(this, "Please Login", Toast.LENGTH_LONG).show()
                val i = Intent(this@Cloud, Start::class.java)
                startActivity(i)
                finish()
            } else {
                val savedata = db.insertdata(uname, uinfo, urate, globalVar)
                if (savedata == true) {
                    Toast.makeText(this, "Course selected scessfully", Toast.LENGTH_LONG).show()

                } else {
                    Toast.makeText(this, "course Already Selected", Toast.LENGTH_LONG).show()
                    var fragment: dashboard
                }
            }
        }


    }
}