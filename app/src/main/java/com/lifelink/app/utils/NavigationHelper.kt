package com.lifelink.app.utils

import android.app.Activity
import android.content.Intent
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.lifelink.app.R
import com.lifelink.app.activities.DashboardActivity
import com.lifelink.app.activities.DonationHistoryActivity
import com.lifelink.app.activities.ProfileActivity
import com.lifelink.app.activities.SearchDonorActivity

/**
 * The app uses 4 top-level Activities (Dashboard/Search/History/Profile) that each host
 * their own BottomNavigationView, rather than a single Activity with Fragments — matching
 * the "Intent Navigation" requirement. This helper wires tab selection consistently so
 * behavior/animations stay identical across all four screens.
 */
object NavigationHelper {

    enum class Tab { HOME, SEARCH, HISTORY, PROFILE }

    fun setup(activity: Activity, bottomNav: BottomNavigationView, current: Tab) {
        bottomNav.selectedItemId = when (current) {
            Tab.HOME -> R.id.nav_home
            Tab.SEARCH -> R.id.nav_search
            Tab.HISTORY -> R.id.nav_history
            Tab.PROFILE -> R.id.nav_profile
        }

        bottomNav.setOnItemSelectedListener { item ->
            val target: Class<*>? = when (item.itemId) {
                R.id.nav_home -> if (current != Tab.HOME) DashboardActivity::class.java else null
                R.id.nav_search -> if (current != Tab.SEARCH) SearchDonorActivity::class.java else null
                R.id.nav_history -> if (current != Tab.HISTORY) DonationHistoryActivity::class.java else null
                R.id.nav_profile -> if (current != Tab.PROFILE) ProfileActivity::class.java else null
                else -> null
            }
            if (target != null) {
                val intent = Intent(activity, target).apply {
                    flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
                }
                activity.startActivity(intent)
                activity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
            }
            true
        }
    }
}
