package com.lifelink.app.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.lifelink.app.models.DonationHistoryUi
import com.lifelink.app.repository.DonationHistoryRepository

class DonationHistoryViewModel(donationHistoryRepository: DonationHistoryRepository) : ViewModel() {

    val allHistory: LiveData<List<DonationHistoryUi>> = donationHistoryRepository.allHistory
}
