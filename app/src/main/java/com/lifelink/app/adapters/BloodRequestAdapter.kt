package com.lifelink.app.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.lifelink.app.R
import com.lifelink.app.databinding.ItemBloodRequestBinding
import com.lifelink.app.entities.BloodRequest

/**
 * Lists all emergency blood requests (pending first, most recent on top).
 * Lets the user mark a request as fulfilled or remove it entirely.
 */
class BloodRequestAdapter(
    private val onMarkCompleted: (BloodRequest) -> Unit,
    private val onDelete: (BloodRequest) -> Unit
) : ListAdapter<BloodRequest, BloodRequestAdapter.RequestViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RequestViewHolder {
        val binding = ItemBloodRequestBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RequestViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RequestViewHolder, position: Int) {
        holder.bind(getItem(position), onMarkCompleted, onDelete)
    }

    class RequestViewHolder(private val binding: ItemBloodRequestBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            item: BloodRequest,
            onMarkCompleted: (BloodRequest) -> Unit,
            onDelete: (BloodRequest) -> Unit
        ) {
            val context = binding.root.context
            binding.tvPatientName.text = item.patientName
            binding.tvBloodGroup.text = item.bloodGroup
            binding.tvHospitalCity.text = "${item.hospital}, ${item.city}"
            binding.tvUnitsUrgency.text =
                "${item.units} units • ${item.urgency} • ${item.contactNumber}"
            binding.tvRequestDate.text = item.date

            if (item.completed) {
                binding.tvStatus.text = "Completed"
                binding.tvStatus.setBackgroundResource(R.drawable.bg_status_available)
                binding.btnMarkCompleted.visibility = android.view.View.GONE
            } else {
                binding.tvStatus.text = "Pending"
                binding.tvStatus.setBackgroundResource(R.drawable.bg_status_unavailable)
                binding.btnMarkCompleted.visibility = android.view.View.VISIBLE
            }

            binding.btnMarkCompleted.setOnClickListener { onMarkCompleted(item) }
            binding.btnDeleteRequest.setOnClickListener { onDelete(item) }
        }
    }

    private object DiffCallback : DiffUtil.ItemCallback<BloodRequest>() {
        override fun areItemsTheSame(oldItem: BloodRequest, newItem: BloodRequest) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: BloodRequest, newItem: BloodRequest) =
            oldItem == newItem
    }
}
