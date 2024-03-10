package com.server.restful_polls.service.impl

import com.server.restful_polls.database.dao.FreeAnswerDao
import com.server.restful_polls.database.dao.SurveyDao
import com.server.restful_polls.model.mapper.FreeSurveyMapper
import com.server.restful_polls.model.request.SurveyRequest
import com.server.restful_polls.model.response.SurveyResponse
import com.server.restful_polls.service.AdminSurveyService
import com.test.project.model.request.SurveyRequest
import com.test.project.model.response.SurveyResponse
import com.test.project.repositories.daos.FreeAnswerDao
import com.test.project.repositories.daos.SurveyDao
import com.test.project.services.SurveyService
import jakarta.transaction.Transactional
import org.springframework.data.jpa.repository.Modifying
import org.springframework.stereotype.Service

@Service
class AdminSurveyServiceImpl(
    private val surveyDao: SurveyDao,
    private val freeAnswerDao: FreeAnswerDao,
    private val freeSurveyMapper: FreeSurveyMapper,
) : SurveyService {
    override fun list(): List<SurveyResponse> {
        val surveys = surveyDao.findAll()
        val surveyResponseList = mutableListOf<SurveyResponse>()
        for (survey in surveys) {
            val answerList = freeAnswerDao.findAllBySurveyEntityId(survey.entityId).map { it.answer }
            surveyResponseList.add(freeSurveyMapper.asResponse(survey, answerList))
        }
        return surveyResponseList
    }

    override fun findSurveyById(entityId: Long): SurveyResponse {
        val survey = surveyDao.findSurveyByEntityId(entityId) ?: throw Exception("Not found")
        val answerList = freeAnswerDao.findAllBySurveyEntityId(survey.entityId).map { it.answer }
        return freeSurveyMapper.asResponse(survey, answerList)
    }

    @Transactional
    override fun createSurvey(request: SurveyRequest): SurveyResponse {
        val survey = freeSurveyMapper.asEntity(request).also { surveyDao.save(it) }
        return freeSurveyMapper.asResponse(survey, listOf())
    }

    @Transactional
    @Modifying
    override fun startStopSurvey(entityId: Long, flag: Boolean): SurveyResponse {
        val survey = surveyDao.findSurveyByEntityId(entityId) ?: throw Exception("Not found")
        val updated = freeSurveyMapper.update(survey, flag)
        val answerList = freeAnswerDao.findAllBySurveyEntityId(survey.entityId).map { it.answer }
        return freeSurveyMapper.asResponse(updated,answerList)
    }

    @Transactional
    @Modifying
    override fun deleteSurvey(entityId: Long) {
        val survey = surveyDao.findSurveyByEntityId(entityId) ?: throw Exception("Not found")
        freeAnswerDao.findFreeAnswersBySurveyEntityId(entityId).forEach { freeAnswerDao.delete(it) }
        surveyDao.delete(survey)
    }
}