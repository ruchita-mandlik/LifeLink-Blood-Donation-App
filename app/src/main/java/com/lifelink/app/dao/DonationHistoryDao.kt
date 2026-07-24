package com.lifelink.app.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.lifelink.app.entities.DonationHistory
import com.lifelink.app.models.DonationHistoryUi

@Dao
interface DonationHistoryDao {

    @Insert
    suspend fun insertHistory(history: DonationHistory): Long

    @Delete
    suspend fun deleteHistory(history: DonationHistory)

    @Query("SELECT * FROM donation_history WHERE donorId = :donorId ORDER BY id DESC")
    fun getHistoryForDonor(donorId: Int): LiveData<List<DonationHistory>>

    /** Joined query producing readable rows (donor name + blood group) for the history screen. */
    @Query(
        """
        SELECT dh.id as historyId, dh.donorId as donorId, d.name as donorName,
               d.bloodGroup as bloodGroup, dh.donationDate as donationDate,
               dh.hospital as hospital, dh.remarks as remarks
        FROM donation_history dh
        INNER JOIN donors d ON dh.donorId = d.id
        ORDER BY dh.id DESC
        """
    )
    fun getAllHistoryWithDonor(): LiveData<List<DonationHistoryUi>>

    @Query(
        """
        SELECT dh.id as historyId, dh.donorId as donorId, d.name as donorName,
               d.bloodGroup as bloodGroup, dh.donationDate as donationDate,
               dh.hospital as hospital, dh.remarks as remarks
        FROM donation_history dh
        INNER JOIN donors d ON dh.donorId = d.id
        ORDER BY dh.id DESC LIMIT :limit
        """
    )
    fun getRecentHistoryWithDonor(limit: Int): LiveData<List<DonationHistoryUi>>
}
