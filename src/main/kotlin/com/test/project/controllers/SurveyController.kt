package com.test.project.controllers

import com.server.restful_polls.model.message.AnswerMessage
import com.server.restful_polls.model.request.AnswerRequest
import com.server.restful_polls.model.response.SurveyUserVersion
import com.test.project.model.message.AnswerMessage
import com.test.project.model.request.AnswerRequest

interface SurveyController {
    fun getSurveyList(): List<SurveyUserVersion>
    fun giveAnswer(id: Long, answerRequest: AnswerRequest): AnswerMessage
}