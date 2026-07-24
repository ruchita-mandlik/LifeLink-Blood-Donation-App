package com.lifelink.app.repository

import androidx.lifecycle.LiveData
import com.lifelink.app.dao.DonorDao
import com.lifelink.app.entities.Donor
import com.lifelink.app.models.BloodGroupStat

/**
 * Single source of truth for donor CRUD + search operations.
 */
class DonorRepository(private val donorDao: DonorDao) {

    val allDonors: LiveData<List<Donor>> = donorDao.getAllDonors()
    val totalDonorCount: LiveData<Int> = donorDao.getTotalDonorCount()
    val bloodGroupStats: LiveData<List<BloodGroupStat>> = donorDao.getBloodGroupStats()

    suspend fun addDonor(donor: Donor): Result<Long> {
        return try {
            Result.success(donorDao.insertDonor(donor))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun updateDonor(donor: Donor): Result<Unit> {
        return try {
            donorDao.updateDonor(donor)
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun deleteDonor(donor: Donor): Result<Unit> {
        return try {
            donorDao.deleteDonor(donor)
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    fun getDonorById(id: Int): LiveData<Donor?> = donorDao.getDonorById(id)

    suspend fun getDonorByIdSync(id: Int): Donor? = donorDao.getDonorByIdSync(id)

    fun searchDonors(bloodGroup: String, city: String, query: String): LiveData<List<Donor>> =
        donorDao.searchDonors(bloodGroup, city, query)
}
