package com.example.kiliaro.presenter.splash

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.example.kiliaro.databinding.ActivitySplashBinding
import com.example.kiliaro.presenter.BaseActivity
import com.example.kiliaro.presenter.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : BaseActivity<SplashState, SplashViewModel>() {
    override val viewModel: SplashViewModel by viewModels()

    lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun launchMainActivity() =
        startActivity(Intent(this, MainActivity::class.java)).also { finish() }


    override fun onStateChange(state: SplashState) {
        when (state) {
            SplashState.IDLE -> {
                launchMainActivity()
            }
        }
    }
}