package com.test.project.model.response

import java.time.LocalDate
import java.time.LocalDateTime

class UserResponse(
    override val id: Long,
    override val createdAt: LocalDateTime,
    val name: String,
    val email: String
): EntityResponse