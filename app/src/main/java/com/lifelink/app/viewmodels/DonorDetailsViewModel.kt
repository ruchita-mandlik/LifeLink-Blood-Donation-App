package com.lifelink.app.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lifelink.app.entities.DonationHistory
import com.lifelink.app.entities.Donor
import com.lifelink.app.repository.DonationHistoryRepository
import com.lifelink.app.repository.DonorRepository
import kotlinx.coroutines.launch

class DonorDetailsViewModel(
    private val donorRepository: DonorRepository,
    private val donationHistoryRepository: DonationHistoryRepository
) : ViewModel() {

    private var donorId: Int = 0

    private val _donor = MutableLiveData<Donor?>()

    private val _deleteResult = MutableLiveData<Result<Unit>>()
    val deleteResult: LiveData<Result<Unit>> = _deleteResult

    private val _addHistoryResult = MutableLiveData<Result<Unit>>()
    val addHistoryResult: LiveData<Result<Unit>> = _addHistoryResult

    fun loadDonor(id: Int): LiveData<Donor?> {
        donorId = id
        return donorRepository.getDonorById(id)
    }

    fun historyForDonor(id: Int): LiveData<List<DonationHistory>> =
        donationHistoryRepository.getHistoryForDonor(id)

    fun deleteDonor(donor: Donor) {
        viewModelScope.launch {
            _deleteResult.value = donorRepository.deleteDonor(donor)
        }
    }

    fun markDonationComplete(donorId: Int, hospital: String, date: String, remarks: String, donor: Donor) {
        viewModelScope.launch {
            val history = DonationHistory(
                donorId = donorId,
                donationDate = date,
                hospital = hospital,
                remarks = remarks
            )
            val historyResult = donationHistoryRepository.addHistory(history)
            if (historyResult.isSuccess) {
                donorRepository.updateDonor(
                    donor.copy(
                        lastDonationDate = date,
                        available = false
                    )
                )
            }
            _addHistoryResult.value = historyResult.map { }
        }
    }
}
