package com.lifelink.app.repository

import androidx.lifecycle.LiveData
import com.lifelink.app.dao.DonationHistoryDao
import com.lifelink.app.entities.DonationHistory
import com.lifelink.app.models.DonationHistoryUi

class DonationHistoryRepository(private val donationHistoryDao: DonationHistoryDao) {

    val allHistory: LiveData<List<DonationHistoryUi>> = donationHistoryDao.getAllHistoryWithDonor()

    fun getRecentHistory(limit: Int = 5): LiveData<List<DonationHistoryUi>> =
        donationHistoryDao.getRecentHistoryWithDonor(limit)

    fun getHistoryForDonor(donorId: Int): LiveData<List<DonationHistory>> =
        donationHistoryDao.getHistoryForDonor(donorId)

    suspend fun addHistory(history: DonationHistory): Result<Long> {
        return try {
            val id = donationHistoryDao.insertHistory(history)
            android.util.Log.d("HISTORY_TEST", "Inserted History ID = $id")
            Result.success(id)
        } catch (e: Exception) {
            android.util.Log.e("HISTORY_TEST", "Insert Failed", e)
            Result.failure(e)
        }
    }

    suspend fun deleteHistory(history: DonationHistory): Result<Unit> {
        return try {
            donationHistoryDao.deleteHistory(history)
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
