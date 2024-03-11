package com.test.project.model.mapper

import com.test.project.model.request.SurveyRequest
import com.test.project.model.response.SurveyResponse
import com.test.project.repositories.entities.Survey
import org.springframework.stereotype.Component

@Component
class SurveyMapper {
    fun asEntity(request: SurveyRequest) = Survey(
        surveyMessage = request.surveyMessage,
        surveyType = request.surveyType,
    )
    fun asResponse(survey: Survey, answerList: List<String>) = SurveyResponse(
        entityId = survey.entityId,
        createdAt = survey.createdAt,
        surveyMessage = survey.surveyMessage,
        surveyType = survey.surveyType,
        answers = answerList
    )
    fun update(survey: Survey): Survey{
        TODO("Nothing implement to update")
        return survey
    }
}