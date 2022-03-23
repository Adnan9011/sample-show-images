package com.example.kilario.presenter.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.example.kilario.R
import com.example.kilario.databinding.ItemAlbumBinding
import com.example.kilario.models.ui.SharedMediaUi
import com.example.kilario.presenter.BaseViewHolder

class AlbumAdapter : ListAdapter<SharedMediaUi, BaseViewHolder>(DIFF_CALLBACK) {

    private var onItemClickListener: ((item: SharedMediaUi) -> Unit)? = null

    fun setOnClickListener(listener: (item: SharedMediaUi) -> Unit) {
        onItemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder =
        LayoutInflater.from(parent.context).run {
            AlbumViewHolder(inflate(R.layout.item_album, parent, false), Glide.with(parent.context))
        }


    inner class AlbumViewHolder(itemView: View, private val glide: RequestManager): BaseViewHolder(itemView) {
        val binding: ItemAlbumBinding = ItemAlbumBinding.bind(itemView)

        init {
            itemView.setOnClickListener {
                onItemClickListener?.invoke(currentList[adapterPosition])
            }
        }

        override fun bind(position: Int) {
            val row = currentList[position]

            glide.load(row.thumbnailUrl).into(binding.imgAlabum)
            binding.tvAlbumSize.text = row.getSizeOfImage()
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) = holder.bind()

    companion object {
        val DIFF_CALLBACK = object: DiffUtil.ItemCallback<SharedMediaUi>() {
            override fun areItemsTheSame(oldItem: SharedMediaUi, newItem: SharedMediaUi) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: SharedMediaUi, newItem: SharedMediaUi) =
                oldItem == newItem
        }
    }

}