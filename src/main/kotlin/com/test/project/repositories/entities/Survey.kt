package com.test.project.repositories.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated

@Entity
class Survey(
    @Column(nullable = false, length = 256)
    var surveyMessage: String,

    @Column(nullable = false, length = 64)
    @Enumerated(EnumType.STRING)
    var surveyType: SurveyType,

    @Column(nullable = false, length = 16)
    var isItContinuing: Boolean,
) : AbstractEntity()

enum class SurveyType {
    SINGLE_ANSWER_TEST,
    MULTI_ANSWER_TEST,
    FREE_ANSWER_TEST
}