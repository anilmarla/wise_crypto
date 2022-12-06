package com.anil.wisecrypto.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isInvisible
import com.anil.wisecrypto.R
import com.anil.wisecrypto.databinding.ActivityLoginScreenBinding
import com.anil.wisecrypto.databinding.ActivityNewBinding

class NewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnClear.setOnClickListener {
            binding.texthello.setVisibility(View.INVISIBLE)

        }
    }
}