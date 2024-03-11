package com.test.project.repositories.daos

import com.test.project.model.message.AnswerMessage
import com.test.project.model.request.AnswerRequest
import com.test.project.repositories.entities.Answer

interface AnswerDao: CommonDao<Answer>{
    fun findAnswersBySurveyId(id: Long): List<Answer>
}