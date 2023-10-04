package com.example.quizapp.screens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.quizapp.MainActivity
import com.example.quizapp.R
import com.example.quizapp.databinding.ActivityLoginBinding
import com.example.quizapp.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        binding.singUpBtn.setOnClickListener {
            signUp()
        }


        binding.loginBtn.setOnClickListener{
            val intent = Intent(this@SignUpActivity, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun signUp(){
        val email = binding.emailAddress.text.toString()
        val password = binding.newPassword.text.toString().trim()
        val confirmPassword = binding.confirmPassword.text.toString().trim()

        if(email.isBlank()){
            binding.emailAddress.error = "Enter your Email"
            binding.emailAddress.requestFocus()
            return
        }
        if(password.isBlank()){
            binding.newPassword.error = "Enter your new password"
            binding.newPassword.requestFocus()
            return
        }
        if(confirmPassword.isBlank()){
            binding.confirmPassword.error = "Enter your confirm password"
            binding.confirmPassword.requestFocus()
            return
        }
        if(password.length < 6){
            Toast.makeText(this, "Password should 6 or more character!", Toast.LENGTH_SHORT).show()
        }
        if(password != confirmPassword){
            Toast.makeText(this, "Password doesn't match!", Toast.LENGTH_SHORT).show()
        }


        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
            if(it.isSuccessful){
                Toast.makeText(this, "Successfully Sign up!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@SignUpActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
            else{
                Toast.makeText(this, "Authentication is unsuccessful!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}