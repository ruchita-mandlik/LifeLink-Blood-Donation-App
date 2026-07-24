package com.lifelink.app.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.widget.addTextChangedListener
import com.google.android.material.chip.Chip
import com.lifelink.app.LifeLinkApp
import com.lifelink.app.R
import com.lifelink.app.adapters.DonorAdapter
import com.lifelink.app.databinding.ActivitySearchDonorBinding
import com.lifelink.app.utils.Constants
import com.lifelink.app.utils.NavigationHelper
import com.lifelink.app.utils.SessionGuard
import com.lifelink.app.viewmodels.SearchDonorViewModel
import com.lifelink.app.viewmodels.ViewModelFactory

/**
 * Search tab: combined search across free-text query, blood group chips, and city —
 * all filters compose together against Room via [SearchDonorViewModel].
 */
class SearchDonorActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySearchDonorBinding
    private lateinit var adapter: DonorAdapter

    private val viewModel: SearchDonorViewModel by viewModels {
        ViewModelFactory(donorRepository = (application as LifeLinkApp).donorRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (!SessionGuard.requireLogin(this)) return

        binding = ActivitySearchDonorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar.toolbar)
        supportActionBar?.title = getString(R.string.search)

        setupRecyclerView()
        setupBloodGroupChips()
        setupSearchView()
        setupCityFilter()
        observeViewModel()

        NavigationHelper.setup(this, binding.bottomNav, NavigationHelper.Tab.SEARCH)
    }

    private fun setupRecyclerView() {
        adapter = DonorAdapter { donor ->
            val intent = Intent(this, DonorDetailsActivity::class.java)
                .putExtra(Constants.EXTRA_DONOR_ID, donor.id)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_left_in, R.anim.slide_left_out)
        }
        binding.rvDonors.adapter = adapter
    }

    private fun setupBloodGroupChips() {
        val allChip = Chip(this).apply {
            text = "All"
            isCheckable = true
            isChecked = true
        }
        binding.chipGroupBloodGroup.addView(allChip)

        Constants.BLOOD_GROUPS.forEach { group ->
            val chip = Chip(this).apply {
                text = group
                isCheckable = true
            }
            binding.chipGroupBloodGroup.addView(chip)
        }

        binding.chipGroupBloodGroup.setOnCheckedStateChangeListener { group, checkedIds ->
            val chip = checkedIds.firstOrNull()?.let { group.findViewById<Chip>(it) }
            val selected = chip?.text?.toString().orEmpty()
            viewModel.setBloodGroupFilter(if (selected == "All" || selected.isEmpty()) "" else selected)
        }
    }

    private fun setupSearchView() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                viewModel.setQueryFilter(query.orEmpty())
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                viewModel.setQueryFilter(newText.orEmpty())
                return true
            }
        })
    }

    private fun setupCityFilter() {
        binding.etCityFilter.addTextChangedListener { text ->
            viewModel.setCityFilter(text?.toString().orEmpty())
        }
    }

    private fun observeViewModel() {
        viewModel.searchResults.observe(this) { donors ->
            adapter.submitList(donors)
            val isEmpty = donors.isEmpty()
            binding.emptyState.root.visibility = if (isEmpty) android.view.View.VISIBLE else android.view.View.GONE
            binding.rvDonors.visibility = if (isEmpty) android.view.View.GONE else android.view.View.VISIBLE
        }
    }
}
