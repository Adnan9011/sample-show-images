package com.example.kiliaro.presenter.main

import android.app.Application
import android.util.Log
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
import javax.net.ssl.SSLHandshakeException

@HiltViewModel
class MainViewModel @Inject constructor(
    app: Application,
    private val sharesRepository: SharesRepository
): BaseViewModel<MainState>(MainState.IDLE, app) {

    val listMediaSingleLiveEvent = SingleLiveEvent<Pair<List<SharedMediaUi>,Boolean>>()
    val progressSingleLiveEvent = SingleLiveEvent<Boolean>()

    fun getMedia(getFromServer:Boolean = true) {
        viewModelScope.launch(Dispatchers.Default) {
            progressSingleLiveEvent.postValue(true)

            try {
                val result = sharesRepository.getListMedia(sharedId = BuildConfig.SHARED_ID,getFromServer = getFromServer)

                listMediaSingleLiveEvent.postValue(result)
                progressSingleLiveEvent.postValue(false)

            } catch (exp: Exception) {
                progressSingleLiveEvent.postValue(false)

                if(getFromServer)
                    getMedia(getFromServer = false)

                if(exp is SSLHandshakeException) {
                    message.postValue("Failed, Unable to connect to Internet")
                } else
                    message.postValue(exp.message)
            }
        }
    }
}