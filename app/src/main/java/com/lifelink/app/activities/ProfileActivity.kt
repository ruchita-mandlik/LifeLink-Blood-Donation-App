package com.lifelink.app.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.lifelink.app.LifeLinkApp
import com.lifelink.app.R
import com.lifelink.app.databinding.ActivityProfileBinding
import com.lifelink.app.utils.NavigationHelper
import com.lifelink.app.utils.SessionGuard
import com.lifelink.app.viewmodels.ProfileViewModel
import com.lifelink.app.viewmodels.ViewModelFactory

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding

    private val viewModel: ProfileViewModel by viewModels {
        ViewModelFactory(userRepository = (application as LifeLinkApp).userRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (!SessionGuard.requireLogin(this)) return

        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar.toolbar)
        supportActionBar?.title = getString(R.string.profile)

        setupMenuRows()

        val app = application as LifeLinkApp
        binding.tvName.text = app.sessionManager.getUserName()
        binding.tvEmail.text = app.sessionManager.getUserEmail()

        NavigationHelper.setup(this, binding.bottomNav, NavigationHelper.Tab.PROFILE)
    }

    private fun setupMenuRows() {
        binding.rowEditProfile.ivIcon.setImageResource(R.drawable.ic_edit)
        binding.rowEditProfile.tvLabel.text = getString(R.string.edit_profile)
        binding.rowEditProfile.root.setOnClickListener {
            startActivity(Intent(this, EditProfileActivity::class.java))
            overridePendingTransition(R.anim.slide_left_in, R.anim.slide_left_out)
        }

        binding.rowDonationHistory.ivIcon.setImageResource(R.drawable.ic_history)
        binding.rowDonationHistory.tvLabel.text = getString(R.string.donation_history)
        binding.rowDonationHistory.root.setOnClickListener {
            startActivity(Intent(this, DonationHistoryActivity::class.java))
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        }

        binding.rowSettings.ivIcon.setImageResource(R.drawable.ic_settings)
        binding.rowSettings.tvLabel.text = getString(R.string.settings)
        binding.rowSettings.root.setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
            overridePendingTransition(R.anim.slide_left_in, R.anim.slide_left_out)
        }

        binding.rowAbout.ivIcon.setImageResource(R.drawable.ic_info)
        binding.rowAbout.tvLabel.text = getString(R.string.about)
        binding.rowAbout.root.setOnClickListener {
            startActivity(Intent(this, AboutActivity::class.java))
            overridePendingTransition(R.anim.slide_left_in, R.anim.slide_left_out)
        }

        binding.rowLogout.ivIcon.setImageResource(R.drawable.ic_logout)
        binding.rowLogout.tvLabel.text = getString(R.string.logout)
        binding.rowLogout.root.setOnClickListener { confirmLogout() }
    }

    private fun confirmLogout() {
        AlertDialog.Builder(this)
            .setTitle(R.string.logout)
            .setMessage("Are you sure you want to logout?")
            .setPositiveButton(R.string.logout) { _, _ -> performLogout() }
            .setNegativeButton(R.string.cancel, null)
            .show()
    }

    private fun performLogout() {
        SessionGuard.logout(this)
    }
}
