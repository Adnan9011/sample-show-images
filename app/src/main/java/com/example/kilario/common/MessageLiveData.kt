package com.example.kilario.common

import android.content.Context
import androidx.annotation.MainThread
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer

class MessageLiveData(private val context: Context) : SingleLiveEvent<String>() {

    @MainThread
    override fun observe(owner: LifecycleOwner, observer: Observer<in String>) {
        super.observe(owner, Observer {
            val translatedMessage = translateErrorMessage(it, context)
            observer.onChanged(translatedMessage ?: it)
        })
    }

    @MainThread
    override fun setValue(t: String?) {
        super.setValue(t)
    }

    private fun translateErrorMessage(message: String, context: Context): String? {
        val enum = valueOfOrNull<ErrorMessages>(message)

        enum ?: return null

        return context.getString(enum.stringRes)
    }
}