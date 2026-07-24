package com.lifelink.app.models

data class DonationHistoryUi(
    val historyId: Int,
    val donorId: Int,
    val donorName: String,
    val bloodGroup: String,
    val donationDate: String,
    val hospital: String,
    val remarks: String
)