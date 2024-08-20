    package com.example.authenticationusinglocaldb

    import android.content.Intent
    import android.health.connect.datatypes.units.Length
    import androidx.appcompat.app.AppCompatActivity
    import android.os.Bundle
    import android.util.Log
    import android.widget.Toast
    import android.widget.Toast.LENGTH_SHORT
    import com.example.authenticationusinglocaldb.databinding.ActivityLoginBinding

    class LoginActivity : AppCompatActivity() {
        private lateinit var binding : ActivityLoginBinding
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityLoginBinding.inflate(layoutInflater)
            setContentView(binding.root)
            binding.btnLogin.setOnClickListener {
//                var pref = getSharedPreferences("AUTH", MODE_PRIVATE)
//                val editor = pref.edit()
//                editor.putBoolean("check",true)
//                editor.apply()
                var pref = getSharedPreferences("CRED", MODE_PRIVATE)
                var username = pref.getString("username","default_user")
                val password = pref.getString("pass","default_pass")
                if(username.equals(binding.username.text.toString()) && password.equals(binding.password.text.toString())) {
                    Toast.makeText(this, "Sucessfully logged in", Toast.LENGTH_SHORT).show()
                    var pref = getSharedPreferences("AUTH", MODE_PRIVATE)
                    val editor = pref.edit()
                    editor.putBoolean("check",true)
                    editor.apply()
                    Log.d("loginActivity", "login Button Clicked!")
                    startActivity(Intent(this,MainActivity::class.java))
                    finish()
                }
                else {
                    Toast.makeText(this,"Invalid Username/Password. Try again",Toast.LENGTH_SHORT).show()
                }

            }
            binding.btnRegister.setOnClickListener{
                startActivity(Intent(this,RegisterActivity::class.java))
                finish()

            }
//            finish()
        }
    }