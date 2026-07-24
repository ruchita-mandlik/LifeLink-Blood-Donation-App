package com.lifelink.app.activities

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.lifelink.app.LifeLinkApp
import com.lifelink.app.R
import com.lifelink.app.databinding.ActivityRegisterDonorBinding
import com.lifelink.app.entities.Donor
import com.lifelink.app.utils.Constants
import com.lifelink.app.utils.DateUtils
import com.lifelink.app.utils.SnackbarUtils
import com.lifelink.app.utils.Validator
import com.lifelink.app.utils.SessionGuard
import com.lifelink.app.viewmodels.RegisterDonorViewModel
import com.lifelink.app.viewmodels.ViewModelFactory

/**
 * Handles both "Register Donor" (new) and "Edit Donor" flows. When launched with
 * [Constants.EXTRA_DONOR_ID] it pre-fills the form from the existing donor and
 * updates instead of inserting on save.
 */
class RegisterDonorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterDonorBinding
    private var editingDonor: Donor? = null

    private val viewModel: RegisterDonorViewModel by viewModels {
        ViewModelFactory(donorRepository = (application as LifeLinkApp).donorRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (!SessionGuard.requireLogin(this)) return
        binding = ActivityRegisterDonorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar.toolbar)

        binding.toolbar.toolbar.setNavigationIcon(R.drawable.ic_back)
        binding.toolbar.toolbar.setNavigationOnClickListener {
            finish()
        }

        setupSpinners()
        setupDatePicker()

        val donorId = intent.getIntExtra(Constants.EXTRA_DONOR_ID, -1)
        if (donorId != -1) {
            supportActionBar?.title = getString(R.string.edit)
            loadDonorForEdit(donorId)
        } else {
            supportActionBar?.title = getString(R.string.register_donor)
        }

        binding.btnSaveDonor.setOnClickListener { attemptSave() }
        observeViewModel()
    }

    private fun setupSpinners() {
        binding.spinnerGender.adapter = ArrayAdapter(
            this, android.R.layout.simple_spinner_dropdown_item, Constants.GENDERS
        )
        binding.spinnerBloodGroup.adapter = ArrayAdapter(
            this, android.R.layout.simple_spinner_dropdown_item, Constants.BLOOD_GROUPS
        )
    }

    private fun setupDatePicker() {
        binding.etLastDonationDate.setOnClickListener {
            DateUtils.showDatePicker(this, binding.etLastDonationDate)
        }
    }

    private fun loadDonorForEdit(donorId: Int) {
        (application as LifeLinkApp).donorRepository.getDonorById(donorId).observe(this) { donor ->
            donor ?: return@observe
            editingDonor = donor
            binding.etName.setText(donor.name)
            binding.etAge.setText(donor.age.toString())
            binding.etCity.setText(donor.city)
            binding.etPhone.setText(donor.phone)
            binding.etLastDonationDate.setText(donor.lastDonationDate ?: "")
            binding.switchAvailable.isChecked = donor.available
            binding.spinnerGender.setSelection(Constants.GENDERS.indexOf(donor.gender).coerceAtLeast(0))
            binding.spinnerBloodGroup.setSelection(Constants.BLOOD_GROUPS.indexOf(donor.bloodGroup).coerceAtLeast(0))
        }
    }

    private fun attemptSave() {
        val name = binding.etName.text.toString()
        val ageText = binding.etAge.text.toString()
        val city = binding.etCity.text.toString()
        val phone = binding.etPhone.text.toString()

        val nameError = Validator.validateName(name)
        val ageError = Validator.validateAge(ageText)
        val cityError = Validator.validateNotEmpty(city, "City")
        val phoneError = Validator.validatePhone(phone)

        binding.tilName.error = nameError
        binding.tilAge.error = ageError
        binding.tilCity.error = cityError
        binding.tilPhone.error = phoneError

        if (listOf(nameError, ageError, cityError, phoneError).any { it != null }) return

        val donor = Donor(
            id = editingDonor?.id ?: 0,
            name = name.trim(),
            age = ageText.trim().toInt(),
            gender = binding.spinnerGender.selectedItem.toString(),
            bloodGroup = binding.spinnerBloodGroup.selectedItem.toString(),
            city = city.trim(),
            phone = phone.trim(),
            lastDonationDate = binding.etLastDonationDate.text.toString().ifBlank { null },
            available = binding.switchAvailable.isChecked
        )
        viewModel.saveDonor(donor)
    }

    private fun observeViewModel() {
        viewModel.isLoading.observe(this) { isLoading ->
            binding.progressBar.visibility = if (isLoading) android.view.View.VISIBLE else android.view.View.GONE
            binding.btnSaveDonor.isEnabled = !isLoading
        }
        viewModel.saveResult.observe(this) { result ->
            result.onSuccess {
                SnackbarUtils.showSuccess(binding.root, "Donor saved successfully")
                finish()
            }.onFailure { error ->
                SnackbarUtils.showError(binding.root, error.message ?: "Failed to save donor")
            }
        }
    }
}
