package com.test.project.model.request

import com.test.project.repositories.entities.SurveyType

class SurveyRequest (
    val surveyMessage: String,
    val surveyType: SurveyType
)