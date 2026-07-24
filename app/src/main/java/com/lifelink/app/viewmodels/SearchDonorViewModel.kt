package com.lifelink.app.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import androidx.lifecycle.ViewModel
import com.lifelink.app.entities.Donor
import com.lifelink.app.repository.DonorRepository

/**
 * Drives Search Donor screen: combined search by blood group, city and free-text query
 * (name or phone). Filters are held in LiveData so changing any one of them automatically
 * re-runs the Room query via switchMap.
 */
class SearchDonorViewModel(private val donorRepository: DonorRepository) : ViewModel() {

    private val bloodGroupFilter = MutableLiveData("")
    private val cityFilter = MutableLiveData("")
    private val queryFilter = MutableLiveData("")

    private val filters = androidx.lifecycle.MediatorLiveData<Triple<String, String, String>>().apply {
        fun update() {
            value = Triple(bloodGroupFilter.value ?: "", cityFilter.value ?: "", queryFilter.value ?: "")
        }
        addSource(bloodGroupFilter) { update() }
        addSource(cityFilter) { update() }
        addSource(queryFilter) { update() }
    }

    val searchResults = filters.switchMap { (bloodGroup, city, query) ->
        donorRepository.searchDonors(bloodGroup, city, query)
    }

    fun setBloodGroupFilter(bloodGroup: String) {
        bloodGroupFilter.value = bloodGroup
    }

    fun setCityFilter(city: String) {
        cityFilter.value = city
    }

    fun setQueryFilter(query: String) {
        queryFilter.value = query
    }
}
