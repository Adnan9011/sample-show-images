package com.example.kiliaro.presenter.detailmedia

import android.app.Application
import com.example.kiliaro.presenter.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailMediaViewModel @Inject constructor(
    app: Application
) : BaseViewModel<DetailMediaState>(DetailMediaState.IDLE, app)