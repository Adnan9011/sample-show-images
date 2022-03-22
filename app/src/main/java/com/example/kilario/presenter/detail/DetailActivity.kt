package com.example.kilario.presenter.detail

import android.os.Bundle
import androidx.activity.viewModels
import com.example.kilario.databinding.ActivityDetailBinding
import com.example.kilario.presenter.BaseActivity

class DetailActivity: BaseActivity<DetailState, DetailViewModel>() {
    override val viewModel: DetailViewModel by viewModels()

    lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStateChange(state: DetailState) {
        when(state) {
            DetailState.IDLE -> {}
        }
    }
}