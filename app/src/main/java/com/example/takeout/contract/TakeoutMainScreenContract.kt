package com.example.takeout.contract

import androidx.lifecycle.LiveData

interface TakeoutMainScreenContract {

    interface TakeMainScreenViewModelInput{
        fun viewDidLoad()
        //Navigation bar
        fun didClickNavigationBarLearnMoreButton()
        fun didClickNavigationBarSearchButton()
        fun didClickNavigationBarSlideMenuButton()
    }

    interface TakeMainScreenViewModelOutput{
        //Navigation
        val gotoTakeoutLearnMorePage: LiveData<Nothing>
        val gotoTakeoutSearchPage: LiveData<Nothing>
        val gotoTakeoutMenuPage: LiveData<Nothing>
    }

    interface TakeoutMainScreenRouter{
        fun navigationToTakeoutLearnMorePage()
        fun navigationToTakeoutSearchPage()
        fun navigationToTakeoutMenuPage()
    }

    interface ITakeoutMainScreenRepository{
        fun getTakeoutAccountAsync()
        fun getTotalMarketValuesAsync()
        fun getBuyingPowerAsync()
    }

}