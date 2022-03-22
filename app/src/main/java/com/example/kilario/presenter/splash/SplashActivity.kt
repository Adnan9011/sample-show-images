package com.example.kilario.presenter.splash

import android.os.Bundle
import androidx.activity.viewModels
import com.example.kilario.databinding.ActivitySplashBinding
import com.example.kilario.presenter.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity: BaseActivity<SplashState, SplashViewModel>() {
    override val viewModel: SplashViewModel by viewModels()

    lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStateChange(state: SplashState) {
        when(state) {
            SplashState.IDLE -> {}
        }
    }
}