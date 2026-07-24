package com.lifelink.app.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.viewModels
import com.lifelink.app.LifeLinkApp
import com.lifelink.app.R
import com.lifelink.app.databinding.ActivityLoginBinding
import com.lifelink.app.utils.SnackbarUtils
import com.lifelink.app.utils.Validator
import com.lifelink.app.viewmodels.LoginViewModel
import com.lifelink.app.viewmodels.ViewModelFactory

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    private val viewModel: LoginViewModel by viewModels {
        ViewModelFactory(userRepository = (application as LifeLinkApp).userRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener { attemptLogin() }
        binding.tvGoToRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
            overridePendingTransition(R.anim.slide_left_in, R.anim.slide_left_out)
        }

        observeViewModel()
    }

    private fun attemptLogin() {
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()

        val emailError = Validator.validateEmail(email)
        val passwordError = Validator.validatePassword(password)

        binding.tilEmail.error = emailError
        binding.tilPassword.error = passwordError

        if (emailError != null || passwordError != null) return

        viewModel.login(email, password)
    }

    private fun observeViewModel() {
        viewModel.isLoading.observe(this) { isLoading ->
            binding.progressBar.visibility = if (isLoading) android.view.View.VISIBLE else android.view.View.GONE
            binding.btnLogin.isEnabled = !isLoading
        }

        viewModel.loginResult.observe(this) { result ->
            result.onSuccess { user ->
                val app = application as LifeLinkApp
                app.sessionManager.createSession(user.id, user.name, user.email)
                SnackbarUtils.showSuccess(binding.root, "Welcome back, ${user.name}!")
                val intent = Intent(this, DashboardActivity::class.java).apply {
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                }
                startActivity(intent)
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
                finish()
            }.onFailure { error ->
                SnackbarUtils.showError(binding.root, error.message ?: "Login failed")
            }
        }
    }
}
