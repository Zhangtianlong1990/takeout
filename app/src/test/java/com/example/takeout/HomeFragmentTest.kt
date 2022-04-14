package com.example.takeout

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.takeout.mock.MockHomeFragment
import com.example.takeout.repository.TakeoutRepository
import com.example.takeout.viewmodel.TakeoutMainScreenViewModel
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomeFragmentTest {

    lateinit var mockHomeFragment : MockHomeFragment
    lateinit var viewModel : TakeoutMainScreenViewModel
    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

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