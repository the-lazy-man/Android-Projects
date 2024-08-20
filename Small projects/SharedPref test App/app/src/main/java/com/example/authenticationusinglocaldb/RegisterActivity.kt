package com.example.authenticationusinglocaldb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.authenticationusinglocaldb.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    lateinit var binding : ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnRegister.setOnClickListener {
            var pref = getSharedPreferences("CRED", MODE_PRIVATE)
            var editor = pref.edit()
            editor.putString("username", binding.tvUsername.text.toString())
            editor.putString("pass", binding.tvPassword.text.toString())
            editor.apply()
            Log.d("Check button", "Register Button Clicked!")
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
        binding.tvLogin.setOnClickListener{
            startActivity(Intent(this,LoginActivity::class.java))
            finish()
        }

//        finish()
    }
}