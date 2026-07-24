package com.lifelink.app.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.lifelink.app.dao.BloodRequestDao
import com.lifelink.app.dao.DonationHistoryDao
import com.lifelink.app.dao.DonorDao
import com.lifelink.app.dao.UserDao
import com.lifelink.app.entities.BloodRequest
import com.lifelink.app.entities.DonationHistory
import com.lifelink.app.entities.Donor
import com.lifelink.app.entities.User

/**
 * Central Room database for the LifeLink app. Exposed as a thread-safe singleton so the
 * whole app shares a single connection.
 */
@Database(
    entities = [User::class, Donor::class, BloodRequest::class, DonationHistory::class],
    version = 2,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun donorDao(): DonorDao
    abstract fun bloodRequestDao(): BloodRequestDao
    abstract fun donationHistoryDao(): DonationHistoryDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "lifelink_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
