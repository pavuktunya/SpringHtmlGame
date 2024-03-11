package com.test.project.model.mapper

import com.test.project.model.request.SurveyRequest
import com.test.project.model.response.SurveyResponse
import com.test.project.repositories.entities.Survey
import org.springframework.stereotype.Component

@Component
class FreeSurveyMapper {
    fun asEntity(request: SurveyRequest) = Survey(
        surveyMessage = request.surveyMessage,
        surveyType = request.surveyType,
        isItContinuing = request.isItContinuing,
    )

    fun asResponse(survey: Survey, answerList: List<String>) = SurveyResponse(
        entityId = survey.entityId,
        createdAt = survey.createdAt,
        surveyMessage = survey.surveyMessage,
        surveyType = survey.surveyType,
        answers = answerList
    )

    fun update(survey: Survey, flag: Boolean): Survey{
        survey.isItContinuing = flag
        return survey
    }
}