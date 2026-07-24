package com.lifelink.app.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lifelink.app.R
import com.lifelink.app.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Included toolbar
        setSupportActionBar(binding.toolbar.toolbar)

        supportActionBar?.apply {
            title = getString(R.string.about)
            setDisplayHomeAsUpEnabled(true)
        }

        binding.toolbar.toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}