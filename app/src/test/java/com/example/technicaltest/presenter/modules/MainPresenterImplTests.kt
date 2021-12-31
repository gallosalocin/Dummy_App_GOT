package com.example.technicaltest.presenter.modules

import com.example.technicaltest.domain.useCases.GetTestUseCase
import com.example.technicaltest.utils.TestNetworkSchedulers
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.mock
import org.mockito.kotlin.verifyNoMoreInteractions

@RunWith(MockitoJUnitRunner::class)
class MainPresenterImplTests {
    private val mockView: MainView = mock()
    private val mock: GetTestUseCase = mock()
    private val testNetworkScheduler = TestNetworkSchedulers()
    private val presenter = MainPresenterImpl(mock, testNetworkScheduler)

    @Before
    fun setup() {
        presenter.attach(mockView, mock())
    }

    @After
    fun tearDown() {
        verifyNoMoreInteractions(mockView, mock)
    }

    @Test
    fun test() {

    }
}