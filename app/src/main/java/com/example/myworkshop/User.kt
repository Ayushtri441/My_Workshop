package com.example.myworkshop
import com.example.myworkshop.MainActivity.Companion.globalVar
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.TextView

class User : AppCompatActivity() {
    lateinit var edt : TextView
    lateinit var bundle: Bundle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        edt = findViewById(R.id.Ayush)
        bundle = intent.extras!!
        if(bundle!=null) {
            var u = bundle.getString("User").toString()
            edt.setText("Welcome  " + u);

            val handler = Handler();
            handler.postDelayed(object : Runnable {
                override fun run() {
                    globalVar = u
                    val intent = Intent(this@User, Start::class.java)
                    startActivity(intent);
                    finish()

                }
            }, 2000);
        }
    }
}