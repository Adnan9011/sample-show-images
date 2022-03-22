package com.example.kilario.presenter.main

import android.os.Bundle
import androidx.activity.viewModels
import com.example.kilario.databinding.ActivityMainBinding
import com.example.kilario.presenter.BaseActivity

class MainActivity: BaseActivity<MainState, MainViewModel>() {
    override val viewModel: MainViewModel by viewModels()

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStateChange(state: MainState) {
        when(state) {
            MainState.IDLE -> {}
        }
    }
}