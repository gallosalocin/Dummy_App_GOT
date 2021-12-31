package com.example.technicaltest.data.vendors.network.api

import com.example.technicaltest.data.vendors.network.router.TestRouter
import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.verifyNoMoreInteractions
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class TestServiceApiTests {
    private val mockTestRouter: TestRouter = mock()
    private val serviceApi = TestServiceApiImpl(mockTestRouter)

    @After
    fun tearDown() {
        verifyNoMoreInteractions(mockTestRouter)
    }

    @Test
    fun testSuccess() {
        whenever(mockTestRouter.getTest()).thenReturn(mock())

        serviceApi.getTest()

        verify(mockTestRouter).getTest()
    }
}    