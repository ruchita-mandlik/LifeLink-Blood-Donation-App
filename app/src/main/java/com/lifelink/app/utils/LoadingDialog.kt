package com.lifelink.app.utils

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import com.lifelink.app.R

/**
 * Lightweight, reusable "loading" progress dialog shown during Room DB operations
 * that might take a moment (registration, search, saving records). Built
 * programmatically to avoid needing an extra layout file.
 */
class LoadingDialog(private val context: Context) {

    private var dialog: Dialog? = null

    fun show(message: String = "Loading…") {
        if (dialog?.isShowing == true) return
        val container = LinearLayout(context).apply {
            orientation = LinearLayout.HORIZONTAL
            setPadding(48, 40, 48, 40)
            setBackgroundResource(R.drawable.bg_card_rounded)
            gravity = android.view.Gravity.CENTER_VERTICAL
        }
        val progressBar = ProgressBar(context).apply {
            indeterminateTintList = android.content.res.ColorStateList.valueOf(
                context.getColor(R.color.red_primary)
            )
        }
        val textView = TextView(context).apply {
            text = message
            setPadding(32, 0, 0, 0)
            setTextColor(context.getColor(R.color.text_primary))
            textSize = 16f
        }
        container.addView(progressBar)
        container.addView(textView)

        dialog = Dialog(context).apply {
            setContentView(container)
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            setCancelable(false)
            show()
        }
    }

    fun dismiss() {
        if (dialog?.isShowing == true) {
            dialog?.dismiss()
        }
    }
}
