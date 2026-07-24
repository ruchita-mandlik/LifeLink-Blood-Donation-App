package com.lifelink.app.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lifelink.app.entities.User
import com.lifelink.app.repository.UserRepository
import kotlinx.coroutines.launch

/** Backs both Profile (view) and Edit Profile (update) screens. */
class ProfileViewModel(private val userRepository: UserRepository) : ViewModel() {

    private val _user = MutableLiveData<User?>()
    val user: LiveData<User?> = _user

    private val _updateResult = MutableLiveData<Result<Unit>>()
    val updateResult: LiveData<Result<Unit>> = _updateResult

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading

    fun loadUser(userId: Int) {
        viewModelScope.launch {
            _isLoading.value = true
            _user.value = userRepository.getUserById(userId)
            _isLoading.value = false
        }
    }

    fun updateProfile(user: User) {
        viewModelScope.launch {
            _isLoading.value = true
            _updateResult.value = userRepository.updateUser(user)
            _isLoading.value = false
        }
    }
}
