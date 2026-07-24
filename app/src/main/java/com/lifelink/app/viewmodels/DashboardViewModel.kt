package com.lifelink.app.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.lifelink.app.models.BloodGroupStat
import com.lifelink.app.models.DonationHistoryUi
import com.lifelink.app.repository.DonationHistoryRepository
import com.lifelink.app.repository.DonorRepository

/**
 * Feeds the Dashboard: total donor count, blood group breakdown, and recent donations.
 * All streams are LiveData from Room, so the UI updates automatically as data changes.
 */
class DashboardViewModel(
    donorRepository: DonorRepository,
    donationHistoryRepository: DonationHistoryRepository
) : ViewModel() {

    val totalDonors: LiveData<Int> = donorRepository.totalDonorCount
    val bloodGroupStats: LiveData<List<BloodGroupStat>> = donorRepository.bloodGroupStats
    val recentDonations: LiveData<List<DonationHistoryUi>> = donationHistoryRepository.getRecentHistory(5)
}
