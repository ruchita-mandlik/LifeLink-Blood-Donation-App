package com.lifelink.app.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.lifelink.app.LifeLinkApp
import com.lifelink.app.R
import com.lifelink.app.adapters.DonationHistoryAdapter
import com.lifelink.app.databinding.ActivityDonationHistoryBinding
import com.lifelink.app.utils.NavigationHelper
import com.lifelink.app.utils.SessionGuard
import com.lifelink.app.viewmodels.DonationHistoryViewModel
import com.lifelink.app.viewmodels.ViewModelFactory

class DonationHistoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDonationHistoryBinding
    private lateinit var adapter: DonationHistoryAdapter

    private val viewModel: DonationHistoryViewModel by viewModels {
        ViewModelFactory(donationHistoryRepository = (application as LifeLinkApp).donationHistoryRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (!SessionGuard.requireLogin(this)) return
        binding = ActivityDonationHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar.toolbar)
        supportActionBar?.title = getString(R.string.donation_history)

        adapter = DonationHistoryAdapter()
        binding.rvHistory.adapter = adapter

        viewModel.allHistory.observe(this) { history ->
            adapter.submitList(history)
            val isEmpty = history.isEmpty()
            binding.emptyState.root.visibility = if (isEmpty) android.view.View.VISIBLE else android.view.View.GONE
            binding.rvHistory.visibility = if (isEmpty) android.view.View.GONE else android.view.View.VISIBLE
        }

        NavigationHelper.setup(this, binding.bottomNav, NavigationHelper.Tab.HISTORY)
    }
}
