package com.example.technicaltest.presenter.models

import com.example.technicaltest.domain.models.DomainTest
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class UITestItemMappingTests {

    @Test
    fun testToUIItem() {
        val actualDomain = DomainTest(userId = 1, id = 1, title = "title", body = "body")
        val expectedUIItem = UITestItem(userId = 1, id = 1, title = "title", body = "body")

        assertThat(actualDomain.toUIItem(), equalTo(expectedUIItem))
    }
}