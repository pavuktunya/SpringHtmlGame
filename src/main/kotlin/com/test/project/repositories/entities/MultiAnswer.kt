package com.test.project.repositories.entities

import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

class MultiAnswer (
    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: User,

    @ManyToOne
    @JoinColumn(name = "survey_id")
    val survey: Survey,
) : AbstractEntity()