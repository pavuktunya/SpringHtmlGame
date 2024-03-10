package com.test.project.model.response

import java.time.LocalDateTime

class SurveyResponse(
    override val id: Long,
    override val createdAt: LocalDateTime,
    val num: Int,
    val name: String,
    val email: String
): EntityResponse