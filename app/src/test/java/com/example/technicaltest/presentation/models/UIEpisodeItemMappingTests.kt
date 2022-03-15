package com.example.technicaltest.presentation.models

import com.example.technicaltest.domain.models.DomainEpisode
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class UIEpisodeItemMappingTests {

    @Test
    fun testToUIItem() {
        val expectedUIItem = UIEpisodeItem(url = "url", name = "name", season = 1, number = 1, airdate = "airdate", airtime = "airtime",
            runtime = 60, mediumImage = "medium", originalImage = "original", summary = "summary")
        val actualDomain = DomainEpisode(url = "url", name = "name", season = 1, number = 1, airdate = "airdate", airtime = "airtime",
            runtime = 60, mediumImage = "medium", originalImage = "original", summary = "summary")

        assertThat(actualDomain.toUIItem(), equalTo(expectedUIItem))
    }
}