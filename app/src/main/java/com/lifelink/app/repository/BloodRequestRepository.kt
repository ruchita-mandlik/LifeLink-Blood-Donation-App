package com.lifelink.app.repository

import androidx.lifecycle.LiveData
import com.lifelink.app.dao.BloodRequestDao
import com.lifelink.app.entities.BloodRequest

class BloodRequestRepository(private val bloodRequestDao: BloodRequestDao) {

    val allRequests: LiveData<List<BloodRequest>> = bloodRequestDao.getAllRequests()

    suspend fun addRequest(request: BloodRequest): Result<Long> {
        return try {
            Result.success(bloodRequestDao.insertRequest(request))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun deleteRequest(request: BloodRequest): Result<Unit> {
        return try {
            bloodRequestDao.deleteRequest(request)
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun updateRequest(request: BloodRequest): Result<Unit> {
        return try {
            bloodRequestDao.updateRequest(request)
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
