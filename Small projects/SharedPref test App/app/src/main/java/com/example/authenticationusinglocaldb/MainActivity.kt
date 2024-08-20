package com.example.authenticationusinglocaldb

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.authenticationusinglocaldb.databinding.MainActivityBinding
import com.example.authenticationusinglocaldb.ui.theme.AuthenticationUsingLocalDBTheme

class MainActivity : ComponentActivity() {
    lateinit var txt : TextView
    lateinit var btnCheck : Button
    lateinit var binding : MainActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var pref = getSharedPreferences("CRED", MODE_PRIVATE)
        val editor = pref.edit()
        binding.username.text = "Username : ${pref.getString("username","default_user")}"
        binding.pass.text = "password  : ${pref.getString("pass","default-pass")}"
        binding.logoutBtn.setOnClickListener {
            var sp = getSharedPreferences("AUTH", MODE_PRIVATE)
            val editor = sp.edit()
            editor.putBoolean("check",false)
            editor.apply()
//            startActivity(Intent(this,LoginActivity::class.java))
            finish()
        }

    }
}