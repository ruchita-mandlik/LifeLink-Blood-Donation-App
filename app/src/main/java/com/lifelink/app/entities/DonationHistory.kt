package com.lifelink.app.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

/**
 * Represents a single completed donation event tied to a [Donor].
 * The foreign key cascades on delete, so removing a donor cleans up their history.
 */
@Entity(
    tableName = "donation_history",
    foreignKeys = [
        ForeignKey(
            entity = Donor::class,
            parentColumns = ["id"],
            childColumns = ["donorId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("donorId")]
)
data class DonationHistory(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val donorId: Int,
    val donationDate: String, // "dd/MM/yyyy"
    val hospital: String,
    val remarks: String
)
