package com.anil.wisecrypto.ui.loginPage

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.anil.wisecrypto.R
import com.anil.wisecrypto.databinding.ActivityLoginScreenBinding
import com.anil.wisecrypto.ui.ProfilePageActivity
import com.anil.wisecrypto.ui.home.HomeScreenActivity

class LoginScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginScreenBinding
    private lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        preferences =
            getSharedPreferences(getString(R.string.preferences_name), Context.MODE_PRIVATE)

        /*
        * 1. Form validation
        * 2. Check the values whether they are matched with preferences values
        * */
        binding.apply {
            btnEnter.setOnClickListener {
                // 1. form validation
                val email = enterEmailText.text.toString()
                val password = enterPasswordText.text.toString()

                if(email.isBlank()){
                    inputEmail.error = "Please enter email"
                }else{
                    inputEmail.error = null
                }

                if(password.isBlank()){
                    inpiutPassword.error = "Please enter password"
                }else{
                    inpiutPassword.error = null
                }

                if(email.isNotBlank() && password.isNotBlank()){
                    // 2. Check the values whether they are matched with preferences values
                    val savedEmail = preferences.getString("Email", null)
                    val savedPassword = preferences.getString("Password", null)

                    if(email == savedEmail && savedPassword == password){
                        launchHome()
                    }else{
                        Toast.makeText(this@LoginScreenActivity, "Invalid credentials!", Toast.LENGTH_SHORT).show()
                    }
                }
            }

            fogotPassword.setOnClickListener {
                val intent = Intent(this@LoginScreenActivity, ProfilePageActivity::class.java)
                startActivity(intent)
            }
        }

        // click event of register button
        binding.registerHere.setOnClickListener {
            launchRegisterScreen()
        }
    }

    private fun launchHome() {
        preferences.edit().apply{
            putBoolean("is_logged_in", true)
            apply()
        }

        val intent = Intent(this, HomeScreenActivity::class.java)

        startActivity(intent)
        finish()
    }

    private fun launchRegisterScreen(){
        val intent = Intent(this, RegisterPrivacyScreenActivityActivity::class.java)
        startActivity(intent)
    }
}
