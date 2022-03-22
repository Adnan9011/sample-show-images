package com.example.kilario.presenter.main

import android.app.Application
import com.example.kilario.presenter.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    app: Application
): BaseViewModel<MainState>(MainState.IDLE, app)