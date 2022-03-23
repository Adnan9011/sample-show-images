package com.example.kilario.presenter.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.kilario.BuildConfig
import com.example.kilario.common.SingleLiveEvent
import com.example.kilario.models.ui.SharedMediaUi
import com.example.kilario.presenter.BaseViewModel
import com.example.kilario.repository.SharesRepository
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