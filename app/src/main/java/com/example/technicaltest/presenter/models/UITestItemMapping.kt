package com.example.technicaltest.presenter.models

import com.example.technicaltest.domain.models.DomainTest

fun DomainTest.toUIItem()= UITestItem(userId, id, title, body)