package com.example.technicaltest.data.remote.api

import com.example.technicaltest.data.remote.router.Router
import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.verifyNoMoreInteractions
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class ServiceApiTests {
    private val mockRouter: Router = mock()
    private val serviceApi = ServiceApiImpl(mockRouter)

    @After
    fun tearDown() {
        verifyNoMoreInteractions(mockRouter)
    }

    @Test
    fun testSuccess() {
        whenever(mockRouter.getResponse()).thenReturn(mock())

        serviceApi.getEpisodes()

        verify(mockRouter).getResponse()
    }
}    