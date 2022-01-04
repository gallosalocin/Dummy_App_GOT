package com.example.technicaltest.data.vendors.network.api

import com.example.technicaltest.data.vendors.network.router.DummyRouter
import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.verifyNoMoreInteractions
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class DummyServiceApiTests {
    private val mockDummyRouter: DummyRouter = mock()
    private val serviceApi = DummyServiceApiImpl(mockDummyRouter)

    @After
    fun tearDown() {
        verifyNoMoreInteractions(mockDummyRouter)
    }

    @Test
    fun testSuccess() {
        whenever(mockDummyRouter.getResponse()).thenReturn(mock())

        serviceApi.getEpisodes()

        verify(mockDummyRouter).getResponse()
    }
}    