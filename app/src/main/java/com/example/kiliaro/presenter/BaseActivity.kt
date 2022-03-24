package com.example.kiliaro.presenter

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.kiliaro.common.longToast

abstract class BaseActivity<S, T : BaseViewModel<S>> : AppCompatActivity() {

    val TAG by lazy {this::class.simpleName}

    abstract val viewModel: T

    abstract fun onStateChange(state: S)

    override fun setContentView(layoutResID: Int) {
        super.setContentView(layoutResID)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.state.observe(this , Observer {
            if(it != null) {
                onStateChange(it)
                viewModel.onStateUpdated()
            }
        })

        viewModel.message.observe(this , Observer {
            if (it == null) return@Observer

            showMessage(message = it)
        })
    }

    open fun showMessage(message: String) = longToast(message)

    // Fragment
    protected fun replaceFragment(
        @IdRes containerId: Int,
        fragment: Fragment
    ) {
        supportFragmentManager.beginTransaction()
            .replace(containerId, fragment)
            .commit()
    }
}