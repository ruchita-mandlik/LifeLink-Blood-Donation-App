package com.lifelink.app.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Represents an emergency / planned blood request raised by a patient or relative.
 */
@Entity(tableName = "blood_requests")
data class BloodRequest(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val patientName: String,
    val bloodGroup: String,
    val city: String,
    val hospital: String,
    val units: Int,
    val contactNumber: String,
    val urgency: String, // "Low", "Medium", "High", "Critical"
    val date: String, // "dd/MM/yyyy"
    val completed: Boolean = false
)
