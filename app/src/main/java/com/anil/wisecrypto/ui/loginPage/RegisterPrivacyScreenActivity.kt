package com.anil.wisecrypto.ui.loginPage

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.anil.wisecrypto.R
import com.anil.wisecrypto.databinding.ActivityRegisterPrivacyScreenBinding
import com.anil.wisecrypto.databinding.ActivityRegisterScreenBinding

class RegisterPrivacyScreenActivityActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterPrivacyScreenBinding
    private lateinit var preferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterPrivacyScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        preferences = getSharedPreferences(getString(R.string.preferences_name), Context.MODE_PRIVATE)


        binding.btnLogin.setOnClickListener {
            val password = binding.passwordInput.text.toString()
            val confirmpassword = binding.passwordConfirmInput.text.toString()
            val email = binding.txtinputEmail.text.toString()

            if (password == confirmpassword) {
                binding.inputPassword.error = null
                binding.inputConfirmPassword.error = null

                val editor = preferences.edit()
                editor.putString("Email" , email)
                editor.putString("Password", password)
                editor.apply()

                val intent = Intent(this, LoginScreenActivity::class.java)
                startActivity(intent)
            }else{
                binding.inputPassword.error = "Password didn't match"
                binding.inputConfirmPassword.error = "Password didn't match"
            }
        }
    }
}