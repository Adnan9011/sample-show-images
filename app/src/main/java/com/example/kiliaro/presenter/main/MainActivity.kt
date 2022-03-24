package com.example.kiliaro.presenter.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.kiliaro.databinding.ActivityMainBinding
import com.example.kiliaro.models.ui.SharedMediaUi
import com.example.kiliaro.presenter.BaseActivity
import com.example.kiliaro.presenter.detailmedia.DetailMediaActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity: BaseActivity<MainState, MainViewModel>() {
    override val viewModel: MainViewModel by viewModels()

    lateinit var binding: ActivityMainBinding

    val mediaAdapter = MediaAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
        observer()

        // Get Media
        getMedia()
    }

    private fun init() {
        binding.recyclerMedia.adapter = mediaAdapter

        mediaAdapter.setOnClickListener { sharedMediaUi ->
            launchDetailActivity(sharedMediaUi)
        }
    }

    private fun launchDetailActivity(sharedMediaUi: SharedMediaUi) {
        val intentDetail = Intent(this, DetailMediaActivity::class.java)
        intentDetail.putExtra(DetailMediaActivity.EXTRA_MEDIA , sharedMediaUi)
        startActivity(intentDetail)
    }

    private fun observer() {
        viewModel.listMediaSingleLiveEvent.observe(this, Observer {
            mediaAdapter.submitList(it)
        })
    }

    private fun getMedia() = viewModel.getMedia()

    override fun onStateChange(state: MainState) {
        when(state) {
            MainState.IDLE -> {}
        }
    }
}