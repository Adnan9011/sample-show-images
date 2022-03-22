package com.example.kilario.presenter.detail

import android.app.Application
import com.example.kilario.presenter.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    app: Application
): BaseViewModel<DetailState>(DetailState.IDLE, app)