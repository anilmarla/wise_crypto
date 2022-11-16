package com.anil.wisecrypto.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.anil.wisecrypto.MainActivity
import com.anil.wisecrypto.R
import com.anil.wisecrypto.ui.loginPage.LoginScreenActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({
//               launchMainScreen()
            val intent = Intent(this, LoginScreenActivity::class.java)
            startActivity(intent)
            finish()

        }, 2000)
    }


//    private fun launchMainScreen() {
//        val intent = Intent(this, MainActivity::class.java)
//
//        // clear all backstack activities
//        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//
//        startActivity(intent)
//    }

}