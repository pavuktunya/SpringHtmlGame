package com.test.project.controllers

import com.server.restful_polls.model.message.AbstractMessage
import com.server.restful_polls.model.request.SurveyRequest
import com.server.restful_polls.model.response.SurveyResponse
import com.test.project.model.request.SurveyRequest
import com.test.project.model.response.SurveyResponse

interface AdminSurveyController {
    fun list(): List<SurveyResponse>
    fun findSurveyById(id: Long): SurveyResponse
    fun createSurvey(request: SurveyRequest): SurveyResponse
    fun startStopSurvey(id: Long, flag: Boolean): SurveyResponse
    fun deleteSurvey(id: Long): AbstractMessage
}