package com.lifelink.app.preferences

import android.content.Context
import android.content.SharedPreferences

/**
 * Wraps SharedPreferences to manage the local login session: who is logged in,
 * and whether auto-login should be attempted on next app start.
 */
class SessionManager(context: Context) {

    private val prefs: SharedPreferences =
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    fun createSession(userId: Int, name: String, email: String) {
        prefs.edit()
            .putBoolean(KEY_IS_LOGGED_IN, true)
            .putInt(KEY_USER_ID, userId)
            .putString(KEY_NAME, name)
            .putString(KEY_EMAIL, email)
            .apply()
    }

    fun isLoggedIn(): Boolean = prefs.getBoolean(KEY_IS_LOGGED_IN, false)

    fun getUserId(): Int = prefs.getInt(KEY_USER_ID, -1)

    fun getUserName(): String = prefs.getString(KEY_NAME, "") ?: ""

    fun getUserEmail(): String = prefs.getString(KEY_EMAIL, "") ?: ""

    fun updateName(name: String) {
        prefs.edit().putString(KEY_NAME, name).apply()
    }

    /** Whether the app should switch to dark theme. Read by SettingsActivity. */
    fun isDarkModeEnabled(): Boolean = prefs.getBoolean(KEY_DARK_MODE, false)

    fun setDarkModeEnabled(enabled: Boolean) {
        prefs.edit().putBoolean(KEY_DARK_MODE, enabled).apply()
    }

    /**
     * Clears the session on logout. Uses [SharedPreferences.Editor.commit] (synchronous)
     * rather than apply() so the write is guaranteed to be on disk before any caller
     * navigates away — apply()'s async write could theoretically still be pending if the
     * process were killed immediately after logout, which would leave the old session
     * intact on next launch.
     */
    fun logout() {
        prefs.edit().clear().commit()
    }

    companion object {
        private const val PREF_NAME = "lifelink_session"
        private const val KEY_IS_LOGGED_IN = "is_logged_in"
        private const val KEY_USER_ID = "user_id"
        private const val KEY_NAME = "user_name"
        private const val KEY_EMAIL = "user_email"
        private const val KEY_DARK_MODE = "dark_mode"
    }
}
