package com.anil.wisecrypto.ui.loginPage

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

        initRegistartionTypeDropDown()

        setContentView(binding.root)
    }

    private fun initRegistartionTypeDropDown() {
        val registertype = listOf("User" , "Addministrator" )
        val adapter = ArrayAdapter(this, R.layout.type_register, registertype)

        binding.registerType.setAdapter(adapter)
    }
}