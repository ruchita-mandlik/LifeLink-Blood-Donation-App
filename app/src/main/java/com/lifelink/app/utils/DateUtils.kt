package com.lifelink.app.utils

import android.app.DatePickerDialog
import android.content.Context
import android.widget.EditText
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

/**
 * Small wrapper around [DatePickerDialog] that formats the chosen date as dd/MM/yyyy
 * and writes it straight into the target EditText — used by Register Donor, Donation
 * History and Blood Request screens.
 */
object DateUtils {

    private val formatter = SimpleDateFormat(Constants.DATE_FORMAT, Locale.getDefault())

    fun showDatePicker(context: Context, target: EditText, allowFutureDates: Boolean = false) {
        val calendar = Calendar.getInstance()
        val dialog = DatePickerDialog(
            context,
            { _, year, month, dayOfMonth ->
                calendar.set(year, month, dayOfMonth)
                target.setText(formatter.format(calendar.time))
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        if (!allowFutureDates) {
            dialog.datePicker.maxDate = System.currentTimeMillis()
        }
        dialog.show()
    }

    fun getCurrentDate(): String = formatter.format(Calendar.getInstance().time)
}
