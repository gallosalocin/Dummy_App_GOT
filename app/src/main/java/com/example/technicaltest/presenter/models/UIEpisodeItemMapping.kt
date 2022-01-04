package com.example.technicaltest.presenter.models

import com.example.technicaltest.domain.models.DomainEpisode

fun DomainEpisode.toUIItem()= UIEpisodeItem(url, name, season, number, airdate, mediumImage, originalImage, summary)