package com.test.project.controllers

import com.test.project.model.message.AnswerMessage
import com.test.project.model.request.AnswerRequest
import com.test.project.repositories.entities.Survey

interface SurveyController {
    fun getSurveyList(): List<Survey>
    fun giveAnswer(id: Long, answerRequest: AnswerRequest): AnswerMessage
}