package com.anil.wisecrypto.ui.loginPage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.ArrayAdapter
import com.anil.wisecrypto.R
import com.anil.wisecrypto.databinding.ActivityLoginScreenBinding
import com.anil.wisecrypto.databinding.ActivityRegisterScreenBinding
import com.anil.wisecrypto.databinding.ActivitySplashBinding

class RegisterScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRegistartionTypeDropDown()

        binding.textLogin.setOnClickListener {
            finish()
        }
        binding.btnNext.setOnClickListener {
            val entername = binding.inputNameLayout.text.toString()
            val enterpassword = binding.inputMobilenumber.text.toString()
            if(entername.isEmpty() || enterpassword.isEmpty() ) {
                binding.inputNameLayout.error = "Please enter your name"
                binding.inputMobilenumber.error = "Please enter your password"
                return@setOnClickListener
            }

            binding.inputNameLayout.error = null
            binding.inputMobilenumber.error = null

            val intent = Intent(this, RegisterPrivacyScreenActivityActivity::class.java)

            startActivity(intent)
        }
    }
    private fun initRegistartionTypeDropDown() {
        val registertype = listOf("User" , "Addministrator" )
        val adapter = ArrayAdapter(this, R.layout.type_register, registertype)

        binding.registerType.setAdapter(adapter)
    }

}