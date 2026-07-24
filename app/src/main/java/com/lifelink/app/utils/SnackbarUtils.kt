package com.lifelink.app.utils

import android.view.View
import com.google.android.material.snackbar.Snackbar
import androidx.core.content.ContextCompat
import com.lifelink.app.R

/**
 * Consistent, theme-matching Snackbar helpers used to surface success/error/info
 * messages across every screen instead of ad-hoc Toasts.
 */
object SnackbarUtils {

    fun showSuccess(view: View, message: String) {
        val snackbar = Snackbar.make(view, message, Snackbar.LENGTH_SHORT)
        snackbar.setBackgroundTint(ContextCompat.getColor(view.context, R.color.green_success))
        snackbar.setTextColor(ContextCompat.getColor(view.context, R.color.white))
        snackbar.show()
    }

    fun showError(view: View, message: String) {
        val snackbar = Snackbar.make(view, message, Snackbar.LENGTH_LONG)
        snackbar.setBackgroundTint(ContextCompat.getColor(view.context, R.color.red_error))
        snackbar.setTextColor(ContextCompat.getColor(view.context, R.color.white))
        snackbar.show()
    }

    fun showInfo(view: View, message: String) {
        val snackbar = Snackbar.make(view, message, Snackbar.LENGTH_SHORT)
        snackbar.setBackgroundTint(ContextCompat.getColor(view.context, R.color.grey_dark))
        snackbar.setTextColor(ContextCompat.getColor(view.context, R.color.white))
        snackbar.show()
    }
}
