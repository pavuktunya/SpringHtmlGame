package com.test.project.model.mapper

import com.test.project.model.request.SurveyRequest
import com.test.project.model.response.SurveyResponse
import com.test.project.repositories.entities.Answer
import com.test.project.repositories.entities.Survey
import com.test.project.repositories.entities.SurveyType
import com.test.project.repositories.entities.User
import org.springframework.stereotype.Component
import java.lang.reflect.Array.getByte

@Component
class SurveyMapper {
    fun asEntity(request: SurveyRequest) = Survey(
        user = User("Mikl", "Mikl@mail.ru", "12345"),
        surveyMessage = request.surveyMessage,
        surveyType = request.surveyType.byte
    )
    fun asResponse(survey: Survey, answerList: List<Answer>) = SurveyResponse(
        id = survey.id,
        createdAt = survey.createdAt,
        surveyMessage = survey.surveyMessage,
        surveyType = SurveyType.deByte(survey.surveyType),
        answers = answerList
    )
    fun update(survey: Survey) = SurveyResponse(
        id = survey.id,
        createdAt = survey.createdAt,
        surveyMessage = survey.surveyMessage,
        surveyType = SurveyType.deByte(survey.surveyType),
        answers = listOf()
    )
}