package com.example.listroomcoroutines

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.listroomcoroutines.databinding.ItemNameBinding

class DataItemAdapter(

    private val items: List<DataItem>,

) : RecyclerView.Adapter<DataItemAdapter.DataItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataItemViewHolder {
        val binding = ItemNameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DataItemViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class DataItemViewHolder(private val binding: ItemNameBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(dataItem: DataItem) {
            binding.nameTextView.text = dataItem.name
            binding.bookmarkImageView.visibility = if (dataItem.isBookmarked) View.VISIBLE else View.GONE

        }

    }

}

