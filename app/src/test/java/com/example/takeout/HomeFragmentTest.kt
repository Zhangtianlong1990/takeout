package com.example.takeout

import com.example.takeout.mock.MockHomeFragment
import com.example.takeout.repository.TakeoutRepository
import com.example.takeout.viewmodel.TakeoutMainScreenViewModel
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class HomeFragmentTest {

    lateinit var mockHomeFragment : MockHomeFragment
    lateinit var viewModel : TakeoutMainScreenViewModel
    @Before
    fun setup(){
        viewModel = TakeoutMainScreenViewModel(TakeoutRepository())
        mockHomeFragment = MockHomeFragment(viewModel)
    }

    @Test
    fun test_searchButtonClick(){
        Assert.assertEquals(0, mockHomeFragment.searchButtonClick)
        viewModel.didClickNavigationBarSearchButton()
        Assert.assertEquals(1, mockHomeFragment.searchButtonClick)
    }

}