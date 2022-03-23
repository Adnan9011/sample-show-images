package com.example.kilario.presenter.main

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.kilario.databinding.ActivityMainBinding
import com.example.kilario.presenter.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity: BaseActivity<MainState, MainViewModel>() {
    override val viewModel: MainViewModel by viewModels()

    lateinit var binding: ActivityMainBinding

    val albumAdapter = AlbumAdapter()

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
        binding.recyclerAlbum.adapter = albumAdapter

        albumAdapter.setOnClickListener { model ->
        }
    }

    private fun observer() {
        viewModel.listMediaSingleLiveEvent.observe(this, Observer {
            albumAdapter.submitList(it)
        })
    }

    private fun getMedia() = viewModel.getMedia()

    override fun onStateChange(state: MainState) {
        when(state) {
            MainState.IDLE -> {}
        }
    }
}