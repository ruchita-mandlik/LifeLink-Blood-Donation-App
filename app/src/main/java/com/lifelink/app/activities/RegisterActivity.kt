package com.lifelink.app.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.lifelink.app.LifeLinkApp
import com.lifelink.app.R
import com.lifelink.app.databinding.ActivityRegisterBinding
import com.lifelink.app.utils.SnackbarUtils
import com.lifelink.app.utils.Validator
import com.lifelink.app.viewmodels.RegisterViewModel
import com.lifelink.app.viewmodels.ViewModelFactory

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    private val viewModel: RegisterViewModel by viewModels {
        ViewModelFactory(userRepository = (application as LifeLinkApp).userRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivBack.setOnClickListener { finish() }
        binding.btnRegister.setOnClickListener { attemptRegister() }
        binding.tvGoToLogin.setOnClickListener { finish() }

        observeViewModel()
    }

    private fun attemptRegister() {
        val name = binding.etName.text.toString()
        val email = binding.etEmail.text.toString()
        val phone = binding.etPhone.text.toString()
        val password = binding.etPassword.text.toString()
        val confirmPassword = binding.etConfirmPassword.text.toString()

        val errors = listOf(
            binding.tilName to Validator.validateName(name),
            binding.tilEmail to Validator.validateEmail(email),
            binding.tilPhone to Validator.validatePhone(phone),
            binding.tilPassword to Validator.validatePassword(password),
            binding.tilConfirmPassword to Validator.validateConfirmPassword(password, confirmPassword)
        )
        errors.forEach { (til, error) -> til.error = error }

        if (errors.any { it.second != null }) return

        viewModel.register(name, email, password, phone)
    }

    private fun observeViewModel() {
        viewModel.isLoading.observe(this) { isLoading ->
            binding.progressBar.visibility = if (isLoading) android.view.View.VISIBLE else android.view.View.GONE
            binding.btnRegister.isEnabled = !isLoading
        }

        viewModel.registerResult.observe(this) { result ->
            result.onSuccess {
                SnackbarUtils.showSuccess(binding.root, "Account created! Please login.")
                startActivity(Intent(this, LoginActivity::class.java))
                overridePendingTransition(R.anim.slide_right_in, R.anim.slide_right_out)
                finish()
            }.onFailure { error ->
                SnackbarUtils.showError(binding.root, error.message ?: "Registration failed")
            }
        }
    }
}
