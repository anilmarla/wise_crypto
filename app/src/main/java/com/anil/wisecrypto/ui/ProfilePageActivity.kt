package com.anil.wisecrypto.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.anil.wisecrypto.R
import com.anil.wisecrypto.databinding.ActivityProfilePageBinding
import com.bumptech.glide.Glide

class ProfilePageActivity : AppCompatActivity() {
    private lateinit var binding:ActivityProfilePageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityProfilePageBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        loadimage()

    }

    private fun loadimage() {
        Glide.with(this)
            .load("https://expertphotography.b-cdn.net/wp-content/uploads/2020/08/social-media-profile-photos-3.jpg")
            .circleCrop()
            .into(binding.profilePic)
    }
}