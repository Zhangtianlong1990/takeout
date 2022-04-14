package com.example.takeout

import android.os.Looper
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.takeout.mock.mockTakeoutMainScreenViewModel
import com.example.takeout.repository.TakeoutRepository
import io.mockk.every
import io.mockk.mockkClass
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

class TakeoutMainScreenViewModelTest {

    lateinit var viewModel : mockTakeoutMainScreenViewModel

    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp(){
        viewModel = mockTakeoutMainScreenViewModel(TakeoutRepository())
    }

    @Test
    fun test_searchButtonClick(){

        assertEquals(viewModel.searchButtonClick,0)
        viewModel?.didClickNavigationBarSearchButton()
        assertEquals(viewModel.searchButtonClick,1)
    }

}