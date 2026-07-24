package com.lifelink.app.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.lifelink.app.repository.BloodRequestRepository
import com.lifelink.app.repository.DonationHistoryRepository
import com.lifelink.app.repository.DonorRepository
import com.lifelink.app.repository.UserRepository

/**
 * Single generic factory for every ViewModel in the app. Each ViewModel takes only
 * the repositories it needs; unused parameters are simply not read by that ViewModel.
 * This avoids writing a bespoke Factory class per screen.
 */
class ViewModelFactory(
    private val userRepository: UserRepository? = null,
    private val donorRepository: DonorRepository? = null,
    private val bloodRequestRepository: BloodRequestRepository? = null,
    private val donationHistoryRepository: DonationHistoryRepository? = null
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(LoginViewModel::class.java) ->
                LoginViewModel(userRepository!!) as T

            modelClass.isAssignableFrom(RegisterViewModel::class.java) ->
                RegisterViewModel(userRepository!!) as T

            modelClass.isAssignableFrom(DashboardViewModel::class.java) ->
                DashboardViewModel(donorRepository!!, donationHistoryRepository!!) as T

            modelClass.isAssignableFrom(RegisterDonorViewModel::class.java) ->
                RegisterDonorViewModel(donorRepository!!) as T

            modelClass.isAssignableFrom(SearchDonorViewModel::class.java) ->
                SearchDonorViewModel(donorRepository!!) as T

            modelClass.isAssignableFrom(DonorDetailsViewModel::class.java) ->
                DonorDetailsViewModel(donorRepository!!, donationHistoryRepository!!) as T

            modelClass.isAssignableFrom(BloodRequestViewModel::class.java) ->
                BloodRequestViewModel(bloodRequestRepository!!) as T

            modelClass.isAssignableFrom(DonationHistoryViewModel::class.java) ->
                DonationHistoryViewModel(donationHistoryRepository!!) as T

            modelClass.isAssignableFrom(ProfileViewModel::class.java) ->
                ProfileViewModel(userRepository!!) as T

            else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
    }
}
