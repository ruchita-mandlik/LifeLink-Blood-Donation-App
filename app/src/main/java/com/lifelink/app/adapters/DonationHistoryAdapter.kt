package com.lifelink.app.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.lifelink.app.databinding.ItemDonationHistoryBinding
import com.lifelink.app.models.DonationHistoryUi

class DonationHistoryAdapter :
    ListAdapter<DonationHistoryUi, DonationHistoryAdapter.HistoryViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val binding = ItemDonationHistoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HistoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class HistoryViewHolder(private val binding: ItemDonationHistoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: DonationHistoryUi) {
            binding.tvDonorName.text = item.donorName
            binding.tvBloodGroup.text = item.bloodGroup
            binding.tvHospital.text = item.hospital
            binding.tvDate.text = item.donationDate
            binding.tvRemarks.text = item.remarks
        }
    }

    private object DiffCallback : DiffUtil.ItemCallback<DonationHistoryUi>() {
        override fun areItemsTheSame(oldItem: DonationHistoryUi, newItem: DonationHistoryUi) =
            oldItem.historyId == newItem.historyId

        override fun areContentsTheSame(oldItem: DonationHistoryUi, newItem: DonationHistoryUi) =
            oldItem == newItem
    }
}
