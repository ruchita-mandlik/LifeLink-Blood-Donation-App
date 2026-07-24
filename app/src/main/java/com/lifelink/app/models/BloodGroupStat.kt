package com.lifelink.app.models

/**
 * Simple UI model representing donor count per blood group, used to render
 * the "Blood Group Statistics" section on the Dashboard. Not a Room entity —
 * it is computed at query time via a Room @DatabaseView-style aggregate query.
 */
data class BloodGroupStat(
    val bloodGroup: String,
    val donorCount: Int
)

/**
 * Combined donation history item enriched with the donor's name, used to
 * display readable rows in the Donation History screen without a second lookup.
 */
