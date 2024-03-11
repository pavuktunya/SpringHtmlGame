package com.test.project.model.mapper

import com.test.project.model.request.AnswerRequest
import com.test.project.repositories.entities.Answer
import com.test.project.repositories.entities.Survey
import org.springframework.stereotype.Component

@Component
class AnswerMapper {
    fun asEntity(answer: AnswerRequest, survey: Survey) = Answer(
        answer = answer.answer,
        survey = survey,
    )
}