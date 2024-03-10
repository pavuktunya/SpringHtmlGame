package com.server.restful_polls.service.impl

import com.server.restful_polls.database.dao.FreeAnswerDao
import com.server.restful_polls.database.dao.SurveyDao
import com.server.restful_polls.model.mapper.AnswerMapper
import com.server.restful_polls.model.mapper.MapperSurveyUserVersion
import com.server.restful_polls.model.request.AnswerRequest
import com.server.restful_polls.model.response.SurveyUserVersion
import com.server.restful_polls.service.SurveyService
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