package com.server.restful_polls.service.impl

import com.test.project.model.mapper.AnswerMapper
import com.test.project.model.mapper.MapperSurveyUserVersion
import com.test.project.model.request.AnswerRequest
import com.test.project.repositories.daos.FreeAnswerDao
import com.test.project.repositories.daos.SurveyDao
import com.test.project.services.SurveyService
import org.springframework.stereotype.Service

@Service
class SurveyServiceImpl(
    private val mapperSurveyUserVersion: MapperSurveyUserVersion,
    private val surveyDao: SurveyDao,
    private val freeAnswerDao: FreeAnswerDao,
    private val answerMapper: AnswerMapper
) : SurveyService {
    override fun getSurveyList(): List<SurveyUserVersion> {
        val surveys = surveyDao.findAll()
        return surveys.map { mapperSurveyUserVersion.asResponse(it) }
    }

    override fun giveAnswer(id: Long, answerRequest: AnswerRequest) {
        val survey = surveyDao.findSurveyByEntityId(id) ?: throw Exception("Not found")
        answerMapper.asEntity(answerRequest, survey).also { freeAnswerDao.save(it) }
    }
}