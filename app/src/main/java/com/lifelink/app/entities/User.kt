package com.lifelink.app.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Represents a registered application user (for local authentication).
 */
@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val email: String,
    val password: String,
    val phone: String
)
