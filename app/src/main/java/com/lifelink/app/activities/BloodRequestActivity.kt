package com.lifelink.app.activities

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.lifelink.app.LifeLinkApp
import com.lifelink.app.R
import com.lifelink.app.adapters.BloodRequestAdapter
import com.lifelink.app.databinding.ActivityBloodRequestBinding
import com.lifelink.app.entities.BloodRequest
import com.lifelink.app.utils.Constants
import com.lifelink.app.utils.DateUtils
import com.lifelink.app.utils.SnackbarUtils
import com.lifelink.app.utils.Validator
import com.lifelink.app.utils.SessionGuard
import com.lifelink.app.viewmodels.BloodRequestViewModel
import com.lifelink.app.viewmodels.ViewModelFactory

class BloodRequestActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBloodRequestBinding
    private lateinit var requestAdapter: BloodRequestAdapter

    private val viewModel: BloodRequestViewModel by viewModels {
        ViewModelFactory(bloodRequestRepository = (application as LifeLinkApp).bloodRequestRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (!SessionGuard.requireLogin(this)) return
        binding = ActivityBloodRequestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar.toolbar)
        binding.toolbar.toolbar.setNavigationIcon(R.drawable.ic_back)
        binding.toolbar.toolbar.setNavigationOnClickListener { finish() }
        supportActionBar?.title = getString(R.string.emergency_request)

        binding.spinnerBloodGroup.adapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, Constants.BLOOD_GROUPS)
        binding.spinnerUrgency.adapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, Constants.URGENCY_LEVELS)

        setupRequestsList()
        binding.btnSubmitRequest.setOnClickListener { attemptSubmit() }
        observeViewModel()
    }

    private fun setupRequestsList() {
        requestAdapter = BloodRequestAdapter(
            onMarkCompleted = { request -> confirmMarkCompleted(request) },
            onDelete = { request -> confirmDelete(request) }
        )
        binding.rvRequests.adapter = requestAdapter
    }

    private fun confirmMarkCompleted(request: BloodRequest) {
        AlertDialog.Builder(this)
            .setTitle("Mark as Completed")
            .setMessage("Mark this blood request for ${request.patientName} as fulfilled?")
            .setPositiveButton("Yes") { _, _ -> viewModel.markCompleted(request) }
            .setNegativeButton(R.string.cancel, null)
            .show()
    }

    private fun confirmDelete(request: BloodRequest) {
        AlertDialog.Builder(this)
            .setTitle("Delete Request")
            .setMessage("Remove the blood request for ${request.patientName}?")
            .setPositiveButton(R.string.delete) { _, _ -> viewModel.deleteRequest(request) }
            .setNegativeButton(R.string.cancel, null)
            .show()
    }

    private fun attemptSubmit() {
        val patientName = binding.etPatientName.text.toString()
        val city = binding.etCity.text.toString()
        val hospital = binding.etHospital.text.toString()
        val unitsText = binding.etUnits.text.toString()
        val contact = binding.etContact.text.toString()

        val nameError = Validator.validateName(patientName)
        val cityError = Validator.validateNotEmpty(city, "City")
        val hospitalError = Validator.validateNotEmpty(hospital, "Hospital")
        val unitsError = Validator.validateUnits(unitsText)
        val contactError = Validator.validatePhone(contact)

        binding.tilPatientName.error = nameError
        binding.tilCity.error = cityError
        binding.tilHospital.error = hospitalError
        binding.tilUnits.error = unitsError
        binding.tilContact.error = contactError

        if (listOf(nameError, cityError, hospitalError, unitsError, contactError).any { it != null }) return

        val request = BloodRequest(
            patientName = patientName.trim(),
            bloodGroup = binding.spinnerBloodGroup.selectedItem.toString(),
            city = city.trim(),
            hospital = hospital.trim(),
            units = unitsText.trim().toInt(),
            contactNumber = contact.trim(),
            urgency = binding.spinnerUrgency.selectedItem.toString(),
            date = DateUtils.getCurrentDate()
        )
        viewModel.submitRequest(request)
    }

    private fun observeViewModel() {
        viewModel.isLoading.observe(this) { isLoading ->
            binding.progressBar.visibility = if (isLoading) android.view.View.VISIBLE else android.view.View.GONE
            binding.btnSubmitRequest.isEnabled = !isLoading
        }
        viewModel.saveResult.observe(this) { result ->
            result.onSuccess {
                SnackbarUtils.showSuccess(binding.root, "Blood request submitted successfully")
                clearForm()
            }.onFailure { error ->
                SnackbarUtils.showError(binding.root, error.message ?: "Failed to submit request")
            }
        }
        viewModel.actionResult.observe(this) { result ->
            result.onFailure { error ->
                SnackbarUtils.showError(binding.root, error.message ?: "Action failed")
            }
        }
        viewModel.allRequests.observe(this) { requests ->
            requestAdapter.submitList(requests)
            binding.tvNoRequests.visibility =
                if (requests.isEmpty()) android.view.View.VISIBLE else android.view.View.GONE
            binding.rvRequests.visibility =
                if (requests.isEmpty()) android.view.View.GONE else android.view.View.VISIBLE
        }
    }

    private fun clearForm() {
        binding.etPatientName.text?.clear()
        binding.etCity.text?.clear()
        binding.etHospital.text?.clear()
        binding.etUnits.text?.clear()
        binding.etContact.text?.clear()
        binding.spinnerBloodGroup.setSelection(0)
        binding.spinnerUrgency.setSelection(0)
    }
}
