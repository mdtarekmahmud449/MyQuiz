package com.example.quizapp.screens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.quizapp.MainActivity
import com.example.quizapp.R
import com.example.quizapp.databinding.ActivityLoginBinding
import com.example.quizapp.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        binding.loginBtn.setOnClickListener {
            logIn()
        }

        binding.singUpBtn.setOnClickListener{
            val intent = Intent(this@LoginActivity, SignUpActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
    private fun logIn(){
        val email = binding.emailAddress.text.toString()
        val password =binding.password.text.toString().trim()
        if(email.isBlank()){
            binding.emailAddress.error = "Enter your Email"
            binding.emailAddress.requestFocus()
            return
        }
        if(password.isBlank()){
            binding.password.error = "Enter your password"
            binding.password.requestFocus()
            return
        }
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
            if(it.isSuccessful){
                Toast.makeText(this, "Login successfully!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
            else{
                Toast.makeText(this, "Login failed!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}