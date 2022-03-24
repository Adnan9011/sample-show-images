package com.example.kiliaro.presenter.main

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.example.kiliaro.BuildConfig
import com.example.kiliaro.common.SingleLiveEvent
import com.example.kiliaro.models.ui.SharedMediaUi
import com.example.kiliaro.presenter.BaseViewModel
import com.example.kiliaro.repository.SharesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    app: Application,
    private val sharesRepository: SharesRepository
): BaseViewModel<MainState>(MainState.IDLE, app) {

    val listMediaSingleLiveEvent = SingleLiveEvent<List<SharedMediaUi>>()

    fun getMedia() {
        viewModelScope.launch(Dispatchers.Default) {
            try {
                val listMedia = sharesRepository.getListMedia(BuildConfig.SHARED_ID)
                listMediaSingleLiveEvent.postValue(listMedia)
            } catch (exp: Exception) {
                message.postValue(exp.message)
            }
        }
    }
}