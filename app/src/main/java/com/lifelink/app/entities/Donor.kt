package com.lifelink.app.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Represents a blood donor registered in the system.
 *
 * @param lastDonationDate stored as "dd/MM/yyyy" string, nullable if the donor never donated.
 * @param available whether the donor is currently available to donate.
 */
@Entity(tableName = "donors")
data class Donor(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val age: Int,
    val gender: String,
    val bloodGroup: String,
    val city: String,
    val phone: String,
    val lastDonationDate: String? = null,
    val available: Boolean = true
)
