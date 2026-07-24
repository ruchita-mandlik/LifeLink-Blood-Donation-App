package com.lifelink.app.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lifelink.app.entities.BloodRequest
import com.lifelink.app.repository.BloodRequestRepository
import kotlinx.coroutines.launch

class BloodRequestViewModel(private val bloodRequestRepository: BloodRequestRepository) : ViewModel() {

    val allRequests: LiveData<List<BloodRequest>> = bloodRequestRepository.allRequests

    private val _saveResult = MutableLiveData<Result<Long>>()
    val saveResult: LiveData<Result<Long>> = _saveResult

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading

    private val _actionResult = MutableLiveData<Result<Unit>>()
    val actionResult: LiveData<Result<Unit>> = _actionResult

    fun submitRequest(request: BloodRequest) {
        viewModelScope.launch {
            _isLoading.value = true
            _saveResult.value = bloodRequestRepository.addRequest(request)
            _isLoading.value = false
        }
    }

    fun markCompleted(request: BloodRequest) {
        viewModelScope.launch {
            _actionResult.value = bloodRequestRepository.updateRequest(request.copy(completed = true))
        }
    }

    fun deleteRequest(request: BloodRequest) {
        viewModelScope.launch {
            _actionResult.value = bloodRequestRepository.deleteRequest(request)
        }
    }
}
