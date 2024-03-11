package com.server.restful_polls.service.impl

import com.test.project.model.mapper.AnswerMapper
import com.test.project.model.mapper.SurveyMapper
import com.test.project.model.request.AnswerRequest
import com.test.project.model.request.SurveyRequest
import com.test.project.model.response.SurveyResponse
import com.test.project.repositories.daos.AnswerDao
import com.test.project.repositories.daos.SurveyDao
import com.test.project.services.SurveyService
import jakarta.transaction.Transactional
import org.springframework.data.jpa.repository.Modifying
import org.springframework.stereotype.Service

@Service
class SurveyServiceImpl(
    private val mapperSurveyUserVersion: MapperSurveyUserVersion,
    private val surveyDao: SurveyDao,
    private val answerDao: AnswerDao,
    private val surveyMapper: SurveyMapper,
    private val answerMapper: AnswerMapper
) : SurveyService {
    override fun list(): List<SurveyResponse> {
        val surveys = surveyDao.findAll()
        return surveys.map { mapperSurveyUserVersion.asResponse(it) }
    }
    override fun getById(entityId: Long): SurveyResponse {
        val survey = surveyDao.findEntityById(entityId) ?: throw Exception("Not found")
        val answerList = answerDao.findAllById(survey.id).map { it.answer }
        return surveyMapper.asResponse(survey, answerList)
    }
    @Transactional
    override fun create(request: SurveyRequest): SurveyResponse {
        val survey = surveyMapper.asEntity(request).also { surveyDao.save(it) }
        return surveyMapper.asResponse(survey, listOf())
    }
    @Transactional
    @Modifying
    override fun startStopSurvey(entityId: Long, flag: Boolean): SurveyResponse {
        val survey = surveyDao.findEntityById(entityId) ?: throw Exception("Not found")
        val updated = surveyMapper.update(survey, flag)
        val answerList = answerDao.findAllBySurveyEntityId(survey.id).map { it.answer }
        return surveyMapper.asResponse(updated,answerList)
    }
    @Transactional
    @Modifying
    override fun delete(entityId: Long) {
        val survey = surveyDao.findEntityById(entityId) ?: throw Exception("Not found")
        answerDao.findFreeAnswersBySurveyEntityId(entityId).forEach { answerDao.delete(it) }
        surveyDao.delete(survey)
    }
    override fun giveAnswer(id: Long, answerRequest: AnswerRequest) {
        val survey = surveyDao.findEntityById(id) ?: throw Exception("Not found")
        answerMapper.asEntity(answerRequest, survey).also { answerDao.save(it) }
        return
    }
    override fun update(surveyId: Long, request: SurveyRequest): SurveyResponse {
        TODO("Not yet implemented")
    }
}