package com.lifelink.app.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.lifelink.app.databinding.ItemBloodGroupStatBinding
import com.lifelink.app.models.BloodGroupStat

/** Horizontal RecyclerView adapter shown in the Dashboard's "Blood Group Statistics" section. */
class BloodGroupStatAdapter :
    ListAdapter<BloodGroupStat, BloodGroupStatAdapter.StatViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatViewHolder {
        val binding = ItemBloodGroupStatBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StatViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StatViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class StatViewHolder(private val binding: ItemBloodGroupStatBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(stat: BloodGroupStat) {
            binding.tvBloodGroup.text = stat.bloodGroup
            binding.tvCount.text = stat.donorCount.toString()
        }
    }

    private object DiffCallback : DiffUtil.ItemCallback<BloodGroupStat>() {
        override fun areItemsTheSame(oldItem: BloodGroupStat, newItem: BloodGroupStat) =
            oldItem.bloodGroup == newItem.bloodGroup

        override fun areContentsTheSame(oldItem: BloodGroupStat, newItem: BloodGroupStat) =
            oldItem == newItem
    }
}
