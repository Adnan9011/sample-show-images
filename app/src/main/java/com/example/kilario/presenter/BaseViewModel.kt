package com.example.kilario.presenter

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kilario.common.MessageLiveData
import com.example.kilario.common.SingleLiveEvent

abstract class BaseViewModel<S>(
    private val defaultState: S,
    protected val app: Application
) : ViewModel() {
    val state = MutableLiveData<S>().apply { value = defaultState!! }
    val message = MessageLiveData(app)
    val error = SingleLiveEvent

    open fun onStateUpdated() = Unit

    override fun onCleared() {
        super.onCleared()
    }
}