package com.example.myworkshop

import android.content.Intent
import android.net.wifi.hotspot2.pps.HomeSp
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.view.animation.AlphaAnimation
import com.example.myworkshop.R
import com.example.myworkshop.Start

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        val handler = Handler();
        handler.postDelayed(object : Runnable{
            override fun run() {
                val i = Intent(this@MainActivity,Start::class.java);
                startActivity(i);
                finish()

            }
        },2000);


    }
}