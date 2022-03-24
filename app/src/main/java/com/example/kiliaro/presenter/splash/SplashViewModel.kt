package com.example.kiliaro.presenter.splash

import android.app.Application
import com.example.kiliaro.presenter.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    app: Application
): BaseViewModel<SplashState>(SplashState.IDLE, app)