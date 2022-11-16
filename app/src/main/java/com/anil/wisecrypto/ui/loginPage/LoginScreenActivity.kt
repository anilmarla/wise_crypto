package com.anil.wisecrypto.ui.loginPage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.anil.wisecrypto.R
import com.anil.wisecrypto.databinding.ActivityLoginScreenBinding

class LoginScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEnter.setOnClickListener {
            val enteremail = binding.enterEmailText.text.toString()
            val enterpassword = binding.enterPasswordText.text.toString()

            if (enteremail.isEmpty() || enterpassword.isEmpty()) {
                binding.enterEmailText.error = "Please enter your email "
                binding.enterPasswordText.error = "Please enter your password"
                return@setOnClickListener
            }
            binding.enterEmailText.error = null
            binding.enterPasswordText.error = null

            val intent = Intent(this, LoginScreenActivity::class.java)

            startActivity(intent)
            finish()
        }
        binding.registerHere.setOnClickListener {
            val intent = Intent(this, RegisterScreenActivity::class.java)
            startActivity(intent)
        }
    }


}
