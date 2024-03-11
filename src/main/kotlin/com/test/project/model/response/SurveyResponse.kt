package com.test.project.model.response

import com.test.project.repositories.entities.Answer
import com.test.project.repositories.entities.SurveyType
import java.time.LocalDateTime

class SurveyResponse(
    override val id: Long,
    override val createdAt: LocalDateTime,
    val surveyMessage: String,
    val surveyType: SurveyType,
    val answers: List<Answer>
): EntityResponse