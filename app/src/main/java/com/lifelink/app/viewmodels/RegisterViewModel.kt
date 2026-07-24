package com.lifelink.app.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lifelink.app.entities.User
import com.lifelink.app.repository.UserRepository
import kotlinx.coroutines.launch

class RegisterViewModel(private val userRepository: UserRepository) : ViewModel() {

    private val _registerResult = MutableLiveData<Result<Long>>()
    val registerResult: LiveData<Result<Long>> = _registerResult

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading

    fun register(name: String, email: String, password: String, phone: String) {
        viewModelScope.launch {
            _isLoading.value = true
            val user = User(name = name.trim(), email = email.trim(), password = password, phone = phone.trim())
            _registerResult.value = userRepository.register(user)
            _isLoading.value = false
        }
    }
}
