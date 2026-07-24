package com.lifelink.app.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.lifelink.app.LifeLinkApp
import com.lifelink.app.R
import com.lifelink.app.databinding.ActivityDonorDetailsBinding
import com.lifelink.app.databinding.DialogMarkDonationBinding
import com.lifelink.app.entities.Donor
import com.lifelink.app.utils.Constants
import com.lifelink.app.utils.DateUtils
import com.lifelink.app.utils.SnackbarUtils
import com.lifelink.app.utils.SessionGuard
import com.lifelink.app.viewmodels.DonorDetailsViewModel
import com.lifelink.app.viewmodels.ViewModelFactory

class DonorDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDonorDetailsBinding
    private var currentDonor: Donor? = null

    private val viewModel: DonorDetailsViewModel by viewModels {
        val app = application as LifeLinkApp
        ViewModelFactory(
            donorRepository = app.donorRepository,
            donationHistoryRepository = app.donationHistoryRepository
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (!SessionGuard.requireLogin(this)) return
        binding = ActivityDonorDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar.toolbar)

        binding.toolbar.toolbar.setNavigationIcon(R.drawable.ic_back)
        binding.toolbar.toolbar.setNavigationOnClickListener {
            finish()
        }
        supportActionBar?.title = getString(R.string.donor_details)

        // Set static labels for the reusable detail rows
        binding.rowAge.tvLabel.text = getString(R.string.age)
        binding.rowGender.tvLabel.text = getString(R.string.gender)
        binding.rowCity.tvLabel.text = getString(R.string.city)
        binding.rowPhone.tvLabel.text = getString(R.string.phone_number)
        binding.rowLastDonation.tvLabel.text = getString(R.string.last_donation_date)

        val donorId = intent.getIntExtra(Constants.EXTRA_DONOR_ID, -1)
        if (donorId == -1) {
            finish()
            return
        }

        viewModel.loadDonor(donorId).observe(this) { donor ->
            if (donor == null) {
                finish()
                return@observe
            }
            currentDonor = donor
            bindDonor(donor)
        }

        binding.btnCallDonor.setOnClickListener { callDonor() }
        binding.btnEditDonor.setOnClickListener { editDonor() }
        binding.btnDeleteDonor.setOnClickListener { confirmDelete() }
        binding.btnMarkDonated.setOnClickListener { showMarkDonationDialog() }

        observeViewModel()
    }

    private fun bindDonor(donor: Donor) {
        binding.tvBloodGroupBig.text = donor.bloodGroup
        binding.tvDonorName.text = donor.name
        binding.tvAvailability.text = if (donor.available) getString(R.string.available) else getString(R.string.not_available)
        binding.tvAvailability.setBackgroundResource(
            if (donor.available) R.drawable.bg_status_available else R.drawable.bg_status_unavailable
        )
        binding.rowAge.tvValue.text = "${donor.age} years"
        binding.rowGender.tvValue.text = donor.gender
        binding.rowCity.tvValue.text = donor.city
        binding.rowPhone.tvValue.text = donor.phone
        binding.rowLastDonation.tvValue.text = donor.lastDonationDate ?: "Never donated"
    }

    private fun callDonor() {
        val phone = currentDonor?.phone ?: return
        startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phone")))
    }

    private fun editDonor() {
        val donor = currentDonor ?: return
        val intent = Intent(this, RegisterDonorActivity::class.java)
            .putExtra(Constants.EXTRA_DONOR_ID, donor.id)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_left_in, R.anim.slide_left_out)
    }

    private fun confirmDelete() {
        val donor = currentDonor ?: return
        AlertDialog.Builder(this)
            .setTitle("Delete Donor")
            .setMessage("Are you sure you want to remove ${donor.name} from the donor list?")
            .setPositiveButton(R.string.delete) { _, _ -> viewModel.deleteDonor(donor) }
            .setNegativeButton(R.string.cancel, null)
            .show()
    }

    private fun showMarkDonationDialog() {
        val donor = currentDonor ?: return
        val dialogBinding = DialogMarkDonationBinding.inflate(layoutInflater)
        dialogBinding.etDonationDate.setText(DateUtils.getCurrentDate())
        dialogBinding.etDonationDate.setOnClickListener {
            DateUtils.showDatePicker(this, dialogBinding.etDonationDate)
        }

        val dialog = AlertDialog.Builder(this, androidx.appcompat.R.style.Theme_AppCompat_Light_Dialog_Alert)
            .setTitle("Mark Donation Complete")
            .setView(dialogBinding.root)
            .setPositiveButton(R.string.save, null)
            .setNegativeButton(R.string.cancel, null)
            .create()

        // A default setPositiveButton listener dismisses the dialog immediately on click,
        // even when validation fails below, silently discarding the donation. Overriding the
        // click listener after show() lets us keep the dialog open until the input is valid.
        dialog.setOnShowListener {
            dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener {
                val hospital = dialogBinding.etHospital.text.toString().trim()
                val date = dialogBinding.etDonationDate.text.toString().trim()
                val remarks = dialogBinding.etRemarks.text.toString().trim()
                if (hospital.isEmpty() || date.isEmpty()) {
                    SnackbarUtils.showError(binding.root, "Hospital and date are required")
                    return@setOnClickListener
                }
                viewModel.markDonationComplete(donor.id, hospital, date, remarks, donor)
                dialog.dismiss()
            }
        }
        dialog.show()
    }

    private fun observeViewModel() {
        viewModel.deleteResult.observe(this) { result ->
            result.onSuccess {
                SnackbarUtils.showSuccess(binding.root, "Donor removed")
                finish()
            }.onFailure { error ->
                SnackbarUtils.showError(binding.root, error.message ?: "Failed to delete donor")
            }
        }
        viewModel.addHistoryResult.observe(this) { result ->
            result.onSuccess {
                SnackbarUtils.showSuccess(binding.root, "Donation recorded. Thank you!")
            }.onFailure { error ->
                SnackbarUtils.showError(binding.root, error.message ?: "Failed to record donation")
            }
        }
    }
}
