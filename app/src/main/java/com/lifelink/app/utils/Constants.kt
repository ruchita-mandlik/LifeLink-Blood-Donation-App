package com.lifelink.app.utils

/**
 * App-wide constant values: static lists and Intent extra keys.
 */
object Constants {

    val BLOOD_GROUPS = arrayOf("A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-")

    val GENDERS = arrayOf("Male", "Female", "Other")

    val URGENCY_LEVELS = arrayOf("Low", "Medium", "High", "Critical")

    const val EXTRA_DONOR_ID = "extra_donor_id"
    const val DATE_FORMAT = "dd/MM/yyyy"

    const val MIN_DONOR_AGE = 18
    const val MAX_DONOR_AGE = 65
}
