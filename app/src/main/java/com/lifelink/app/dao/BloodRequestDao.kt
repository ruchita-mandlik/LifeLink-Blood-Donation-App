package com.lifelink.app.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.lifelink.app.entities.BloodRequest

@Dao
interface BloodRequestDao {

    @Insert
    suspend fun insertRequest(request: BloodRequest): Long

    @Update
    suspend fun updateRequest(request: BloodRequest)

    @Delete
    suspend fun deleteRequest(request: BloodRequest)

    @Query("SELECT * FROM blood_requests ORDER BY completed ASC, id DESC")
    fun getAllRequests(): LiveData<List<BloodRequest>>
}
