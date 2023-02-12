package com.example.myworkshop

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class Login : AppCompatActivity() {
    private lateinit var uname : EditText
    private lateinit var pass : EditText
    private lateinit var redirct : TextView
    private lateinit var btn: Button
    private lateinit var db : DBhelper
    override fun onAttachFragment(fragment: Fragment) {
        super.onAttachFragment(fragment)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        uname = findViewById(R.id.username)
        pass = findViewById(R.id.password)
        btn = findViewById(R.id.loginButton)
        redirct = findViewById(R.id.signupRedirectText)
        db = DBhelper(this)
        btn.setOnClickListener{
            val username = uname.text.toString()
            val userpass = pass.text.toString()
            val savedata = db.checkuserpass(username,userpass)
            if(TextUtils.isEmpty(username)|| TextUtils.isEmpty(userpass)){
                Toast.makeText(this, "Add valid Username and Password ", Toast.LENGTH_LONG).show()
            }
            else {
                if(savedata==true){

                    Toast.makeText(this,"Login suscessful", Toast.LENGTH_LONG).show()

                    val i = Intent(this@Login,User::class.java)
                    val bundle =Bundle()
                    bundle.putString("User",username)
                    i.putExtras(bundle)
                    startActivity(i)
                    finish()

                }
                else {
                    Toast.makeText(this,"Not registered ! Please register", Toast.LENGTH_LONG).show()
                }
            }
        }
        redirct.setOnClickListener{
            val i = Intent(this,Start:: class.java)
            Toast.makeText(this,"Not registered ! Please register using signin", Toast.LENGTH_LONG).show()
            startActivity(i)
            finish()
        }
    }
}