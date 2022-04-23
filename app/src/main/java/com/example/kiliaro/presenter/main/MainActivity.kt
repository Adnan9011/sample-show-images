package com.example.kiliaro.presenter.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.kiliaro.databinding.ActivityMainBinding
import com.example.kiliaro.models.ui.SharedMediaUi
import com.example.kiliaro.presenter.BaseActivity
import com.example.kiliaro.presenter.detailmedia.DetailMediaActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<MainState, MainViewModel>() {
    override val viewModel: MainViewModel by viewModels()

    lateinit var binding: ActivityMainBinding

    val mediaAdapter = MediaAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
        observer()
    }

    private fun init() {
        binding.recyclerMedia.adapter = mediaAdapter

        mediaAdapter.setOnClickListener { sharedMediaUi ->
            launchDetailActivity(sharedMediaUi)
        }

        binding.btnTryAgain.setOnClickListener {
            getMedia()
        }
    }

    private fun launchDetailActivity(sharedMediaUi: SharedMediaUi) {
        val intentDetail = Intent(this, DetailMediaActivity::class.java)
        intentDetail.putExtra(DetailMediaActivity.EXTRA_MEDIA, sharedMediaUi)
        startActivity(intentDetail)
    }

    private fun observer() {
        viewModel.progressSingleLiveEvent.observe(this, Observer {
            binding.progressCircular.visibility = if (it) View.VISIBLE else View.GONE
        })

        viewModel.listMediaSingleLiveEvent.observe(this, Observer { result ->
            mediaAdapter.submitList(result.first)
            when (result.second) {
                true -> {
                    binding.cardviewUnableToConnect.visibility = View.GONE
                }
                false -> {
                    binding.cardviewUnableToConnect.visibility = View.VISIBLE
                }
            }
        })
    }

    private fun getMedia() = viewModel.getMedia()

    override fun onStateChange(state: MainState) {
        when (state) {
            MainState.IDLE -> {
                getMedia()
            }
        }
    }
}