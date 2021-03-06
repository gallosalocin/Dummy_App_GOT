package com.example.technicaltest.data.remote.models.dto

import com.example.technicaltest.domain.models.DomainEpisode
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class EpisodeDtoTests {

    @Test
    fun testToDomain() {
        val actualResponse = EpisodeDto(url = "url", name = "name", season = 1, number = 1, airdate = "airdate", airtime = "airtime",
            runtime = 60, image = ImageDto(medium = "medium", original = "original"), summary = "summary")
        val expectedDomain = DomainEpisode(url = "url", name = "name", season = 1, number = 1, airdate = "airdate", airtime = "airtime",
            runtime = 60, mediumImage = "medium", originalImage = "original", summary = "summary")
        assertThat(actualResponse.toDomain(), equalTo(expectedDomain))
    }
}