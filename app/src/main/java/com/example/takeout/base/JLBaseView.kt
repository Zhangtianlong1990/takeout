package com.example.takeout.base

interface JLBaseView {
    fun getLayoutId(): Int //<--Android specific
    fun initializeVariables()
    fun setupTrackDatas()
    fun viewDidLoad()
    fun setupViews()
    fun setupAccessibilitys()
    fun viewDeinit()
    fun initViewModel()
    fun bindViewModel()
}