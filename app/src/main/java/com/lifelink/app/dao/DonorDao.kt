package com.lifelink.app.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.lifelink.app.entities.Donor
import com.lifelink.app.models.BloodGroupStat

@Dao
interface DonorDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertDonor(donor: Donor): Long

    @Update
    suspend fun updateDonor(donor: Donor)

    @Delete
    suspend fun deleteDonor(donor: Donor)

    @Query("SELECT * FROM donors ORDER BY name ASC")
    fun getAllDonors(): LiveData<List<Donor>>

    @Query("SELECT * FROM donors WHERE id = :id LIMIT 1")
    fun getDonorById(id: Int): LiveData<Donor?>

    @Query("SELECT * FROM donors WHERE id = :id LIMIT 1")
    suspend fun getDonorByIdSync(id: Int): Donor?

    @Query("SELECT COUNT(*) FROM donors")
    fun getTotalDonorCount(): LiveData<Int>

    /**
     * Combined search across blood group and city. Empty parameters ("") match all rows
     * because the LIKE pattern becomes '%' when the field is blank.
     */
    @Query(
        """
        SELECT * FROM donors
        WHERE (:bloodGroup = '' OR bloodGroup = :bloodGroup)
        AND (:city = '' OR city LIKE '%' || :city || '%')
        AND (:query = '' OR name LIKE '%' || :query || '%' OR phone LIKE '%' || :query || '%')
        ORDER BY name ASC
        """
    )
    fun searchDonors(bloodGroup: String, city: String, query: String): LiveData<List<Donor>>

    @Query("SELECT bloodGroup, COUNT(*) as donorCount FROM donors GROUP BY bloodGroup")
    fun getBloodGroupStats(): LiveData<List<BloodGroupStat>>
}
