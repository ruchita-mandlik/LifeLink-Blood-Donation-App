package com.lifelink.app.utils

import android.util.Patterns
import com.lifelink.app.utils.Constants.MAX_DONOR_AGE
import com.lifelink.app.utils.Constants.MIN_DONOR_AGE

/**
 * Centralized input validation used across Login / Register / Donor / Blood Request forms.
 * Each function returns a null-safe error message string, or null when the field is valid,
 * so callers can do: validateEmail(x)?.let { editText.error = it } ?: proceed()
 */
object Validator {

    fun validateName(name: String): String? {
        if (name.trim().isEmpty()) return "Name cannot be empty"
        if (name.trim().length < 3) return "Name must be at least 3 characters"
        return null
    }

    fun validateEmail(email: String): String? {
        if (email.trim().isEmpty()) return "Email cannot be empty"
        if (!Patterns.EMAIL_ADDRESS.matcher(email.trim()).matches()) return "Enter a valid email address"
        return null
    }

    fun validatePassword(password: String): String? {
        if (password.isEmpty()) return "Password cannot be empty"
        if (password.length < 6) return "Password must be at least 6 characters"
        return null
    }

    fun validateConfirmPassword(password: String, confirmPassword: String): String? {
        if (confirmPassword.isEmpty()) return "Please confirm your password"
        if (password != confirmPassword) return "Passwords do not match"
        return null
    }

    fun validatePhone(phone: String): String? {
        if (phone.trim().isEmpty()) return "Phone number cannot be empty"
        if (!Patterns.PHONE.matcher(phone.trim()).matches() || phone.trim().length < 10) {
            return "Enter a valid 10-digit phone number"
        }
        return null
    }

    fun validateAge(ageText: String): String? {
        if (ageText.trim().isEmpty()) return "Age cannot be empty"
        val age = ageText.trim().toIntOrNull() ?: return "Enter a valid age"
        if (age < MIN_DONOR_AGE || age > MAX_DONOR_AGE) {
            return "Donor age must be between $MIN_DONOR_AGE and $MAX_DONOR_AGE"
        }
        return null
    }

    fun validateBloodGroup(bloodGroup: String?): String? {
        if (bloodGroup.isNullOrEmpty()) return "Please select a blood group"
        return null
    }

    fun validateNotEmpty(value: String, fieldName: String): String? {
        if (value.trim().isEmpty()) return "$fieldName cannot be empty"
        return null
    }

    fun validateUnits(unitsText: String): String? {
        if (unitsText.trim().isEmpty()) return "Units cannot be empty"
        val units = unitsText.trim().toIntOrNull() ?: return "Enter a valid number of units"
        if (units <= 0 || units > 20) return "Units must be between 1 and 20"
        return null
    }
}
