package com.example.technicaltest.data.models.entities

import com.example.technicaltest.domain.models.DomainTest
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TestResponseTests {

    @Test
    fun testToDomain() {
        val actualResponse = TestResponse(userId = 1, id = 1, title = "title", body = "body")
        val expectedDomain = DomainTest(userId = 1, id = 1, title = "title", body = "body")
        assertThat(actualResponse.toDomain(), equalTo(expectedDomain))
    }
}