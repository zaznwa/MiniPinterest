package com.geeks.minipinterest.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.geeks.minipinterest.databinding.ItemListBinding
import com.geeks.minipinterest.model.models.ApiResponse

class ApiAdapter : ListAdapter<ApiResponse.Hit, ApiAdapter.ApiViewHolder>(ApiDiffUtil) {
    class ApiViewHolder(
        val binding: ItemListBinding,
    ) : RecyclerView.ViewHolder(binding.root){
        fun bind(hit: ApiResponse.Hit) {
            binding.apply {
                Glide.with(itemView)
                    .load(hit.largeImageURL)
                    .into(image)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApiViewHolder {
        val binding = ItemListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ApiViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ApiViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    object ApiDiffUtil : DiffUtil.ItemCallback<ApiResponse.Hit>() {
        override fun areItemsTheSame(oldItem: ApiResponse.Hit, newItem: ApiResponse.Hit): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ApiResponse.Hit, newItem: ApiResponse.Hit): Boolean {
            return oldItem == newItem
        }
    }
}