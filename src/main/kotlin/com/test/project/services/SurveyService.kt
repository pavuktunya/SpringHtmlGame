package com.test.project.services

import com.test.project.model.request.AnswerRequest
import com.test.project.model.request.SurveyRequest
import com.test.project.model.response.SurveyResponse
import com.test.project.model.response.UserResponse

interface SurveyService {
    fun list(): List<SurveyResponse>
    fun getById(entityId: Long): SurveyResponse
    fun giveAnswer(surveyId: Long, answerRequest: AnswerRequest): SurveyResponse
    fun create(request: SurveyRequest): SurveyResponse
    fun update(surveyId: Long, request: SurveyRequest): SurveyResponse
    fun delete(surveyId: Long)
}