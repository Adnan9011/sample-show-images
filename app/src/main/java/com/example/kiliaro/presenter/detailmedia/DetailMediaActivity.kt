package com.example.kiliaro.presenter.detailmedia

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.kiliaro.R
import com.example.kiliaro.databinding.ActivityDetailMediaBinding
import com.example.kiliaro.models.ui.SharedMediaUi
import com.example.kiliaro.presenter.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailMediaActivity : BaseActivity<DetailMediaState, DetailMediaViewModel>() {
    override val viewModel: DetailMediaViewModel by viewModels()

    lateinit var binding: ActivityDetailMediaBinding

    lateinit var sharedMediaUi: SharedMediaUi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailMediaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getParameters()
        initViews()
    }

    private fun getParameters() {
        sharedMediaUi = intent.getParcelableExtra(EXTRA_MEDIA)!!
    }

    private fun initViews() {
        if(sharedMediaUi != null) {
            binding.progressCircular.visibility = View.VISIBLE

            Glide
                .with(this)
                .load(sharedMediaUi.downloadUrl)
                .listener(object: RequestListener<Drawable> {
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        binding.progressCircular.visibility = View.GONE
                        showMessage(getString(R.string.msg_sharedmedia_is_null))
                        return false
                    }

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                        binding.progressCircular.setVisibility(View.GONE)
                        binding.tvMediaDate.setVisibility(View.VISIBLE)
                        return false
                    }
                })
                .into(binding.imgMedia)
            binding.tvMediaDate.text = sharedMediaUi.getFullDate()
        } else {
            showMessage(getString(R.string.msg_sharedmedia_is_null))
        }
    }

    override fun onStateChange(mediaState: DetailMediaState) {
        when(mediaState) {
            DetailMediaState.IDLE -> {}
        }
    }

    companion object {
        const val EXTRA_MEDIA = "EXTRA_MEDIA"
    }
}