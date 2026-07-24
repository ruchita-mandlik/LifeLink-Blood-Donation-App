package com.lifelink.app.activities

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.lifelink.app.LifeLinkApp
import com.lifelink.app.R
import com.lifelink.app.adapters.BloodGroupStatAdapter
import com.lifelink.app.adapters.DonationHistoryAdapter
import com.lifelink.app.databinding.ActivityDashboardBinding
import com.lifelink.app.utils.NavigationHelper
import com.lifelink.app.utils.SessionGuard
import com.lifelink.app.viewmodels.DashboardViewModel
import com.lifelink.app.viewmodels.ViewModelFactory

/**
 * Home tab / app landing screen after login. Shows live donor stats, an emergency
 * request shortcut, quick actions, blood-group breakdown and recent donations —
 * all backed by LiveData so the screen refreshes automatically as Room data changes.
 */
class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding
    private lateinit var statAdapter: BloodGroupStatAdapter
    private lateinit var historyAdapter: DonationHistoryAdapter

    private val viewModel: DashboardViewModel by viewModels {
        val app = application as LifeLinkApp
        ViewModelFactory(
            donorRepository = app.donorRepository,
            donationHistoryRepository = app.donationHistoryRepository
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (!SessionGuard.requireLogin(this)) return

        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar.toolbar)
        supportActionBar?.title = getString(R.string.app_name)

        setupRecyclerViews()
        setupClickListeners()
        observeViewModel()

        NavigationHelper.setup(this, binding.bottomNav, NavigationHelper.Tab.HOME)
    }

    override fun onResume() {
        super.onResume()
        val app = application as LifeLinkApp
        if (!app.sessionManager.isLoggedIn()) return
        binding.tvUserName.text = app.sessionManager.getUserName()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_logout) {
            confirmLogout()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun confirmLogout() {
        AlertDialog.Builder(this)
            .setTitle(R.string.logout)
            .setMessage("Are you sure you want to logout?")
            .setPositiveButton(R.string.logout) { _, _ -> performLogout() }
            .setNegativeButton(R.string.cancel, null)
            .show()
    }

    private fun performLogout() {
        SessionGuard.logout(this)
    }

    private fun setupRecyclerViews() {
        statAdapter = BloodGroupStatAdapter()
        binding.rvBloodGroupStats.adapter = statAdapter

        historyAdapter = DonationHistoryAdapter()
        binding.rvRecentDonations.adapter = historyAdapter
    }

    private fun setupClickListeners() {
        binding.cardEmergency.setOnClickListener {
            startActivity(Intent(this, BloodRequestActivity::class.java))
            overridePendingTransition(R.anim.slide_left_in, R.anim.slide_left_out)
        }
        binding.btnQuickSearch.setOnClickListener {
            startActivity(Intent(this, SearchDonorActivity::class.java))
            overridePendingTransition(R.anim.slide_left_in, R.anim.slide_left_out)
        }
        binding.btnRegisterDonor.setOnClickListener { goToRegisterDonor() }
        binding.fabAddDonor.setOnClickListener { goToRegisterDonor() }
    }

    private fun goToRegisterDonor() {
        startActivity(Intent(this, RegisterDonorActivity::class.java))
        overridePendingTransition(R.anim.scale_up, R.anim.fade_out)
    }

    private fun observeViewModel() {
        viewModel.totalDonors.observe(this) { count ->
            binding.tvTotalDonors.text = (count ?: 0).toString()
        }
        viewModel.bloodGroupStats.observe(this) { stats ->
            statAdapter.submitList(stats)
        }
        viewModel.recentDonations.observe(this) { history ->
            historyAdapter.submitList(history)
            binding.tvNoRecentDonations.visibility =
                if (history.isEmpty()) android.view.View.VISIBLE else android.view.View.GONE
            binding.rvRecentDonations.visibility =
                if (history.isEmpty()) android.view.View.GONE else android.view.View.VISIBLE
        }
    }
}
