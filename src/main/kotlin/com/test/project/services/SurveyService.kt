package com.test.project.services

interface SurveyService {
    fun list(): List<SurveyResponse>
    fun findSurveyById(entityId: Long): SurveyResponse
    fun create(request: SurveyRequest): SurveyResponse
    fun startStop(entityId: Long, flag: Boolean): SurveyResponse
    fun delete(entityId: Long)
}