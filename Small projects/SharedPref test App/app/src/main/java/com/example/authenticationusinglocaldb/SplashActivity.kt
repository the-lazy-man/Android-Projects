package com.example.authenticationusinglocaldb

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler


@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        @Suppress("DEPRECATION")
        Handler().postDelayed( {
            val pref : SharedPreferences = getSharedPreferences("AUTH", MODE_PRIVATE)
            val flag = pref.getBoolean("check",false)

            if(flag){
                startActivity(Intent(this, MainActivity::class.java))
            }
            else {
                startActivity(Intent(this, LoginActivity::class.java))
            }
            finish()
        },3000)
//        finish()
    }
}