package com.test.project.controllers

import com.test.project.model.message.AbstractApiMessage
import com.test.project.model.request.SurveyRequest
import com.test.project.model.response.SurveyResponse

interface AdminSurveyController {
    fun list(): List<SurveyResponse>
    fun findSurveyById(id: Long): SurveyResponse
    fun createSurvey(request: SurveyRequest): SurveyResponse
    fun startStopSurvey(id: Long, flag: Boolean): SurveyResponse
    fun deleteSurvey(id: Long): AbstractApiMessage
}