package com.lifelink.app.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.lifelink.app.LifeLinkApp
import com.lifelink.app.databinding.ActivitySplashBinding
import com.lifelink.app.R

/**
 * Entry point of the app. Shows a branded gradient splash with a scale/fade animation,
 * then auto-navigates based on session state (auto-login) — straight to the Dashboard
 * if a session exists, otherwise to Login.
 */
class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    private val splashDelayMillis = 1800L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val logoAnim = android.view.animation.AnimationUtils.loadAnimation(this, R.anim.splash_logo_anim)
        binding.ivLogo.startAnimation(logoAnim)
        val fadeIn = android.view.animation.AnimationUtils.loadAnimation(this, R.anim.fade_in)
        binding.tvAppName.startAnimation(fadeIn)
        binding.tvTagline.startAnimation(fadeIn)

        Handler(Looper.getMainLooper()).postDelayed({ navigateNext() }, splashDelayMillis)
    }

    private fun navigateNext() {
        val app = application as LifeLinkApp
        val isLoggedIn = app.sessionManager.isLoggedIn()
        val destination = if (isLoggedIn) DashboardActivity::class.java else LoginActivity::class.java
        startActivity(Intent(this, destination))
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        finish()
    }
}
