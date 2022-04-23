package com.example.kiliaro.presenter.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.kiliaro.R
import com.example.kiliaro.databinding.ItemMediaBinding
import com.example.kiliaro.models.ui.SharedMediaUi
import com.example.kiliaro.presenter.BaseViewHolder


class MediaAdapter : ListAdapter<SharedMediaUi, BaseViewHolder>(DIFF_CALLBACK) {

    private var onItemClickListener: ((item: SharedMediaUi) -> Unit)? = null

    fun setOnClickListener(listener: (item: SharedMediaUi) -> Unit) {
        onItemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder =
        LayoutInflater.from(parent.context).run {
            MediaViewHolder(inflate(R.layout.item_media, parent, false), Glide.with(parent.context))
        }


    inner class MediaViewHolder(itemView: View, private val glide: RequestManager) :
        BaseViewHolder(itemView) {
        val binding: ItemMediaBinding = ItemMediaBinding.bind(itemView)

        init {
            itemView.setOnClickListener {
                onItemClickListener?.invoke(currentList[adapterPosition])
            }
        }

        override fun bind(position: Int) {
            val row = currentList[position]

            if (binding.imgAlabum.measuredWidth == 0) {
                val observer: ViewTreeObserver = binding.imgAlabum.viewTreeObserver
                observer.addOnGlobalLayoutListener(object : OnGlobalLayoutListener {
                    override fun onGlobalLayout() {
                        binding.imgAlabum.viewTreeObserver.removeOnGlobalLayoutListener(this)
                        loadImage(glide, row, binding)
                        binding.imgAlabum.requestLayout()
                    }
                })
            } else
                loadImage(glide, row, binding)

            binding.tvMediaSize.text = row.getSizeOfImage()
        }
    }

    private fun loadImage(glide: RequestManager, row: SharedMediaUi, binding: ItemMediaBinding) =
        glide.load(
            row.getThumbnailUrl(
                width = binding.imgAlabum.measuredWidth,
                height = binding.imgAlabum.measuredHeight
            )
        )
            .diskCacheStrategy(DiskCacheStrategy.DATA)
            .into(binding.imgAlabum)

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) = holder.bind()

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<SharedMediaUi>() {
            override fun areItemsTheSame(oldItem: SharedMediaUi, newItem: SharedMediaUi) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: SharedMediaUi, newItem: SharedMediaUi) =
                oldItem == newItem
        }
    }

}