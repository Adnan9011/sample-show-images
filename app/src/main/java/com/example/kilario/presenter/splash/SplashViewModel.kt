package com.example.kilario.presenter.splash

import android.app.Application
import com.example.kilario.presenter.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    app: Application
): BaseViewModel<SplashState>(SplashState.IDLE, app)