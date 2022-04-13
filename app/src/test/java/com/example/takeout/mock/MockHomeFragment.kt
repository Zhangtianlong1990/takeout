package com.example.takeout.mock

import com.example.takeout.ui.fragment.HomeFragment
import com.example.takeout.viewmodel.TakeoutMainScreenViewModel

class MockHomeFragment(viewModel: TakeoutMainScreenViewModel?) : HomeFragment(viewModel) {
    var searchButtonClick:Int = 0
    override fun navigationToTakeoutLearnMorePage() {
        println("MockHomeFragment--navigationToTakeoutLearnMorePage")
    }

    override fun navigationToTakeoutSearchPage() {
        super.navigationToTakeoutSearchPage()
        searchButtonClick++
        println("MockHomeFragment --navigationToTakeoutSearchPage")
    }

    override fun navigationToTakeoutMenuPage() {
        println("MockHomeFragment --navigationToTakeoutMenuPage")
    }
}