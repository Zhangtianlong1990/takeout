package com.example.takeout

import com.example.takeout.mock.mockTakeoutMainScreenViewModel
import com.example.takeout.repository.TakeoutRepository
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

class TakeoutMainScreenViewModelTest {

    lateinit var viewModel : mockTakeoutMainScreenViewModel

    @Before
    fun setup(){
        viewModel = mockTakeoutMainScreenViewModel(TakeoutRepository())
    }

    @Test
    fun test_searchButtonClick(){
        assertEquals(viewModel.searchButtonClick,0)
        viewModel?.didClickNavigationBarSearchButton()
        assertEquals(viewModel.searchButtonClick,1)
    }

}