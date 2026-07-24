package com.lifelink.app.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.lifelink.app.databinding.ItemDonorBinding
import com.lifelink.app.entities.Donor

/**
 * RecyclerView adapter for the donor list shown on Search Donor screen.
 * Uses ListAdapter + DiffUtil so item changes animate smoothly instead of a full rebind.
 */
class DonorAdapter(
    private val onItemClick: (Donor) -> Unit
) : ListAdapter<Donor, DonorAdapter.DonorViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DonorViewHolder {
        val binding = ItemDonorBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DonorViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DonorViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class DonorViewHolder(private val binding: ItemDonorBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(donor: Donor) {
            binding.tvDonorName.text = donor.name
            binding.tvBloodGroup.text = donor.bloodGroup
            binding.tvCity.text = donor.city
            binding.tvPhone.text = donor.phone
            binding.tvAvailability.text = if (donor.available) "Available" else "Not Available"
            binding.tvAvailability.setBackgroundResource(
                if (donor.available) com.lifelink.app.R.drawable.bg_status_available
                else com.lifelink.app.R.drawable.bg_status_unavailable
            )
            binding.root.setOnClickListener { onItemClick(donor) }
        }
    }

    private object DiffCallback : DiffUtil.ItemCallback<Donor>() {
        override fun areItemsTheSame(oldItem: Donor, newItem: Donor) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Donor, newItem: Donor) = oldItem == newItem
    }
}
