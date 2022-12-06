package com.anil.wisecrypto.ui.splash

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.anil.wisecrypto.MainActivity
import com.anil.wisecrypto.R
import com.anil.wisecrypto.ui.home.HomeScreenActivity
import com.anil.wisecrypto.ui.loginPage.LoginScreenActivity

class SplashActivity : AppCompatActivity() {
    private lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        preferences = getSharedPreferences(getString(R.string.preferences_name), Context.MODE_PRIVATE)

        Handler(Looper.getMainLooper()).postDelayed({
               launchMainScreen()
        }, 2000)
    }


    private fun launchMainScreen() {
        val isLoggedIn = preferences.getBoolean("is_logged_in", false)

        if(isLoggedIn){
            val intent = Intent(this, HomeScreenActivity::class.java)

            // clear all backstack activities
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

            startActivity(intent)
        }else{
            val intent = Intent(this, LoginScreenActivity::class.java)

            // clear all backstack activities
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

            startActivity(intent)
        }


    }

}