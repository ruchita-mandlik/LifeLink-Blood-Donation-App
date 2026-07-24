package com.lifelink.app.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lifelink.app.entities.Donor
import com.lifelink.app.repository.DonorRepository
import kotlinx.coroutines.launch

/**
 * Backs both "Register Donor" (create) and "Edit Donor" (update) flows —
 * pass an existing [Donor.id] to switch into update mode.
 */
class RegisterDonorViewModel(private val donorRepository: DonorRepository) : ViewModel() {

    private val _saveResult = MutableLiveData<Result<Unit>>()
    val saveResult: LiveData<Result<Unit>> = _saveResult

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading

    fun saveDonor(donor: Donor) {
        viewModelScope.launch {
            _isLoading.value = true
            val result = if (donor.id == 0) {
                donorRepository.addDonor(donor).map { }
            } else {
                donorRepository.updateDonor(donor)
            }
            _saveResult.value = result
            _isLoading.value = false
        }
    }
}
