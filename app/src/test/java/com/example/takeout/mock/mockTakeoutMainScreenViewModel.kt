package com.example.takeout.mock

import com.example.takeout.contract.TakeoutMainScreenContract
import com.example.takeout.viewmodel.TakeoutMainScreenViewModel

class mockTakeoutMainScreenViewModel(private val takeoutRepository: TakeoutMainScreenContract.ITakeoutMainScreenRepository): TakeoutMainScreenViewModel(takeoutRepository) {
    var searchButtonClick:Int = 0
    override fun didClickNavigationBarSearchButton() {
//        super.didClickNavigationBarSearchButton()
        searchButtonClick++
    }
}