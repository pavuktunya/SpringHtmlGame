package com.test.project.model.mapper

import com.test.project.repositories.entities.Survey
import org.springframework.stereotype.Component

@Component
class MapperSurveyUserVersion {
    fun asResponse(survey: Survey) = SurveyUserVersion(
        surveyType = survey.surveyType,
        surveyMessage = survey.surveyMessage,
        createdAt = survey.createdAt,
        entityId = survey.entityId,
    )
}