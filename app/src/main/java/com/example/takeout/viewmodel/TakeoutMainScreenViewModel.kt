package com.example.takeout.viewmodel

import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import com.example.takeout.contract.TakeoutMainScreenContract
import com.example.takeout.utils.SingleClickEvent

open class TakeoutMainScreenViewModel(private val takeoutRepository: TakeoutMainScreenContract.ITakeoutMainScreenRepository): TakeoutMainScreenContract.TakeMainScreenViewModelInput,TakeoutMainScreenContract.TakeMainScreenViewModelOutput{

    var router : TakeoutMainScreenContract.TakeoutMainScreenRouter? = null

    private var _gotoTakeoutLearnMorePage = SingleClickEvent()
    override val gotoTakeoutLearnMorePage: LiveData<Nothing> = _gotoTakeoutLearnMorePage

    private var _gotoTakeoutSearchPage = SingleClickEvent()
    override val gotoTakeoutSearchPage: LiveData<Nothing> = _gotoTakeoutSearchPage

    private var _gotoTakeoutMenuPage = SingleClickEvent()
    override val gotoTakeoutMenuPage: LiveData<Nothing> = _gotoTakeoutMenuPage

    override fun viewDidLoad() {

    }

    override fun didClickNavigationBarLearnMoreButton() {
        _gotoTakeoutLearnMorePage.call()
    }

    override fun didClickNavigationBarSearchButton() {
        _gotoTakeoutSearchPage.call()
        router?.navigationToTakeoutSearchPage()
    }

    override fun didClickNavigationBarSlideMenuButton() {
        _gotoTakeoutMenuPage.call()
    }


}