package com.lifelink.app.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.lifelink.app.LifeLinkApp
import com.lifelink.app.R
import com.lifelink.app.databinding.ActivityEditProfileBinding
import com.lifelink.app.utils.SnackbarUtils
import com.lifelink.app.utils.SessionGuard
import com.lifelink.app.utils.Validator
import com.lifelink.app.viewmodels.ProfileViewModel
import com.lifelink.app.viewmodels.ViewModelFactory

class EditProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditProfileBinding

    private val viewModel: ProfileViewModel by viewModels {
        ViewModelFactory(userRepository = (application as LifeLinkApp).userRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (!SessionGuard.requireLogin(this)) return
        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar.toolbar)

        binding.toolbar.toolbar.setNavigationIcon(R.drawable.ic_back)
        binding.toolbar.toolbar.setNavigationOnClickListener {
            finish()
        }
        supportActionBar?.title = getString(R.string.edit_profile)

        val app = application as LifeLinkApp
        viewModel.loadUser(app.sessionManager.getUserId())

        viewModel.user.observe(this) { user ->
            user ?: return@observe
            binding.etName.setText(user.name)
            binding.etEmail.setText(user.email)
            binding.etPhone.setText(user.phone)
        }

        binding.btnSave.setOnClickListener { attemptSave() }
        observeViewModel()
    }

    private fun attemptSave() {
        val name = binding.etName.text.toString()
        val phone = binding.etPhone.text.toString()

        val nameError = Validator.validateName(name)
        val phoneError = Validator.validatePhone(phone)
        binding.tilName.error = nameError
        binding.tilPhone.error = phoneError
        if (nameError != null || phoneError != null) return

        val currentUser = viewModel.user.value ?: return
        viewModel.updateProfile(currentUser.copy(name = name.trim(), phone = phone.trim()))
    }

    private fun observeViewModel() {
        viewModel.isLoading.observe(this) { isLoading ->
            binding.progressBar.visibility = if (isLoading) android.view.View.VISIBLE else android.view.View.GONE
            binding.btnSave.isEnabled = !isLoading
        }
        viewModel.updateResult.observe(this) { result ->
            result.onSuccess {
                val app = application as LifeLinkApp
                app.sessionManager.updateName(binding.etName.text.toString().trim())
                SnackbarUtils.showSuccess(binding.root, "Profile updated successfully")
                finish()
            }.onFailure { error ->
                SnackbarUtils.showError(binding.root, error.message ?: "Failed to update profile")
            }
        }
    }
}
