package com.test.project.repositories.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
class FreeAnswer (
    @ManyToOne
    @JoinColumn(name = "survey_id")
    val survey: Survey,

    @Column(nullable = false, length = 256)
    val answer: String,
) : AbstractEntity()