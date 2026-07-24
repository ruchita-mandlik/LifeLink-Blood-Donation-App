package com.lifelink.app.activities // Apni sahi package name check kar lein

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.material.switchmaterial.SwitchMaterial
import com.lifelink.app.R // Apni R file ka path check kar lein
import com.lifelink.app.utils.SessionGuard

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (!SessionGuard.requireLogin(this)) return

        // 1. Saved state load karein
        val sharedPrefs = getSharedPreferences("app_prefs", MODE_PRIVATE)
        val isDarkMode = sharedPrefs.getBoolean("isDarkMode", false)

        // 2. Theme apply karein
        if (isDarkMode) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }

        setContentView(R.layout.activity_settings)

        // 3. Switch setup
        val switchDarkMode = findViewById<SwitchMaterial>(R.id.switchDarkMode)
        switchDarkMode.isChecked = isDarkMode

        switchDarkMode.setOnCheckedChangeListener { _, isChecked ->
            // Preference save karein
            sharedPrefs.edit().putBoolean("isDarkMode", isChecked).apply()

            // Mode change karein
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
    }
}