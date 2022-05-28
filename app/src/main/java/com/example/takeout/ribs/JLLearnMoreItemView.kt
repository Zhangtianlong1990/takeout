package com.example.takeout.ribs

import android.content.Context
import android.util.AttributeSet
import com.example.takeout.uxc.JLListItem

class JLLearnMoreItemView @JvmOverloads  constructor(context: Context?, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    JLListItem(context, attrs, defStyleAttr) {

    override fun initializeVariables() {
        super.initializeVariables()
    }

    override fun bindViewModel() {
        super.bindViewModel()
        viewModel.updateRowData("update title","update detail this is detail this is detail this is detail this is detail this is detail this is detail")
        viewModel.updateButtonVisibility(true)
        viewModel.updateModuleVisibility(true)
    }

}