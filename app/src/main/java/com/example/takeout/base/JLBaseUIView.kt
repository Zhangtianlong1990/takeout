package com.example.takeout.base

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry

abstract class JLBaseUIView @JvmOverloads constructor(context: Context?, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    LinearLayout(context, attrs, defStyleAttr),LifecycleOwner,JLBaseView {
        private lateinit var lifecycleRegistry: LifecycleRegistry
        var activity: AppCompatActivity? = null

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        inflate(context,getLayoutId(),this)
        initializeVariables()
        setupViews()
        setupLiveDataLifeCycle()
        initViewModel()
        bindViewModel()
        setupTrackDatas()
        setupAccessibilitys()
        viewDidLoad()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        releaseLiveData()
    }

    private fun setupLiveDataLifeCycle(){
        lifecycleRegistry = LifecycleRegistry(this)
        lifecycleRegistry.currentState = Lifecycle.State.STARTED
    }

    private fun releaseLiveData(){
        viewDeinit()
        lifecycleRegistry.currentState = Lifecycle.State.DESTROYED
    }

    override fun getLifecycle(): Lifecycle {
        return lifecycleRegistry
    }

}