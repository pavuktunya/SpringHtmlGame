package com.test.project.repositories.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated

@Entity
class Survey(
    @Column(nullable = false, length = 256)
    var surveyMessage: String,
    @Column(nullable = false, length = 32)
    @Enumerated(EnumType.STRING)
    var surveyType: SurveyType
) : AbstractEntity()

enum class SurveyType {
    MULTI_ANSWER_TEST,
    FREE_ANSWER_TEST
}