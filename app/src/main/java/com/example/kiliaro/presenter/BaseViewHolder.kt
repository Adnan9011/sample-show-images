package com.example.kiliaro.presenter

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    protected var manipulationg = false

    fun bind() {
        if (adapterPosition != RecyclerView.NO_POSITION) {
            manipulationg = true
            bind(adapterPosition)
            manipulationg = false
        }
    }

    protected abstract fun bind(position: Int)
}