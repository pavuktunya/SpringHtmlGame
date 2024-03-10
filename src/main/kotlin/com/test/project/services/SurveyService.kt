package com.test.project.services

import com.test.project.model.request.SurveyRequest
import com.test.project.model.response.SurveyResponse

interface SurveyService {
    fun list(): List<SurveyResponse>
    fun findSurveyById(entityId: Long): SurveyResponse
    fun create(request: SurveyRequest): SurveyResponse
    fun startStop(entityId: Long, flag: Boolean): SurveyResponse
    fun delete(entityId: Long)
}