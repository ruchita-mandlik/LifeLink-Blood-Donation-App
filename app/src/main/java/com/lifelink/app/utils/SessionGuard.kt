package com.lifelink.app.utils

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.lifelink.app.LifeLinkApp
import com.lifelink.app.R
import com.lifelink.app.activities.LoginActivity

/**
 * Single source of truth for session enforcement and logout.
 *
 * ROOT CAUSE this fixes: SplashActivity only checks [SessionManager.isLoggedIn] once,
 * on cold start. If Android later recreates a previously-visible screen (e.g.
 * DashboardActivity) straight from a saved back stack — after the OS kills the app
 * process in the background and the user reopens it from Recents, or after any
 * back-stack edge case — that recreation skips Splash entirely and its login check
 * never runs. Without a check inside the recreated screen itself, a logged-out user
 * (or a stale/old account) could still see authenticated screens.
 *
 * Every Activity that requires a logged-in user must call [requireLogin] as the very
 * first line of onCreate(), before touching ViewBinding or any session-dependent data.
 */
object SessionGuard {

    /**
     * @return true if there is a valid session and the caller should continue its
     * normal setup. If there is no session, the user is redirected to [LoginActivity]
     * with the back stack cleared and this Activity is finished — the caller must
     * `return` immediately in that case without doing any further work.
     */
    fun requireLogin(activity: AppCompatActivity): Boolean {
        val app = activity.application as LifeLinkApp
        if (app.sessionManager.isLoggedIn()) return true

        val intent = Intent(activity, LoginActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        activity.startActivity(intent)
        activity.finish()
        return false
    }

    /**
     * Clears the session and resets the entire back stack so LoginActivity becomes the
     * new task root — no previous (Dashboard/Search/History/Profile/etc.) screen can be
     * reached via the back button afterwards, and reopening the app cannot resurrect
     * the old account.
     */
    fun logout(activity: AppCompatActivity) {
        val app = activity.application as LifeLinkApp
        app.sessionManager.logout()

        val intent = Intent(activity, LoginActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        activity.startActivity(intent)
        activity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        activity.finish()
    }
}
