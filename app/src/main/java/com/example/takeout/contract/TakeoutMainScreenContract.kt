package com.example.takeout.contract

import androidx.lifecycle.LiveData
import com.example.takeout.model.BuyingPowerUIModel

interface TakeoutMainScreenContract {

    interface TakeMainScreenViewModelInput{
        fun viewDidLoad()
        //Navigation bar
        fun didClickNavigationBarLearnMoreButton()
        fun didClickNavigationBarSearchButton()
        fun didClickNavigationBarSlideMenuButton()

        fun didClickBuyingPowerLearnMore()
    }

    interface TakeMainScreenViewModelOutput{

        val buyingPowerUIModel: LiveData<BuyingPowerUIModel>

        //Navigation
        val gotoTakeoutLearnMorePage: LiveData<Nothing>
        val gotoTakeoutSearchPage: LiveData<Nothing>
        val gotoTakeoutMenuPage: LiveData<Nothing>

        val gotoBuyingPowerLearnMorePage: LiveData<Nothing>

    }

    interface TakeoutMainScreenRouter{
        fun navigationToTakeoutLearnMorePage()
        fun navigationToTakeoutSearchPage()
        fun navigationToTakeoutMenuPage()
        fun navigationToBuyingPowerLearnMorePage()
    }

    interface ITakeoutMainScreenRepository{
        fun getTakeoutAccountAsync()
        fun getTotalMarketValuesAsync()
        fun getBuyingPowerAsync()
    }

}