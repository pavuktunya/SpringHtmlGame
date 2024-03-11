package com.test.project.controllers

import com.test.project.model.message.AbstractApiMessage
import com.test.project.model.message.Message
import com.test.project.model.request.AnswerRequest
import com.test.project.model.request.SurveyRequest
import com.test.project.model.response.SurveyResponse
import com.test.project.repositories.entities.Answer
import com.test.project.repositories.entities.Survey

interface SurveyController {
    fun list(): List<SurveyResponse>
    fun findSurveyById(id: Long): SurveyResponse
    fun createSurvey(request: SurveyRequest): SurveyResponse
    fun deleteSurvey(id: Long): AbstractApiMessage
    fun giveAnswer(id: Long, answerRequest: AnswerRequest): Message
}