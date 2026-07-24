package com.lifelink.app

import android.app.Application
import com.lifelink.app.database.AppDatabase
import com.lifelink.app.preferences.SessionManager
import com.lifelink.app.repository.BloodRequestRepository
import com.lifelink.app.repository.DonationHistoryRepository
import com.lifelink.app.repository.DonorRepository
import com.lifelink.app.repository.UserRepository

/**
 * Application-wide singleton holder for the database and repositories.
 * Keeping repository instantiation here avoids re-creating them (and their DAOs)
 * in every Activity / ViewModelFactory.
 */
class LifeLinkApp : Application() {

    lateinit var sessionManager: SessionManager
        private set

    val database: AppDatabase by lazy { AppDatabase.getInstance(this) }

    val userRepository: UserRepository by lazy { UserRepository(database.userDao()) }
    val donorRepository: DonorRepository by lazy { DonorRepository(database.donorDao()) }
    val bloodRequestRepository: BloodRequestRepository by lazy {
        BloodRequestRepository(database.bloodRequestDao())
    }
    val donationHistoryRepository: DonationHistoryRepository by lazy {
        DonationHistoryRepository(database.donationHistoryDao())
    }

    override fun onCreate() {
        super.onCreate()
        sessionManager = SessionManager(this)
    }
}
