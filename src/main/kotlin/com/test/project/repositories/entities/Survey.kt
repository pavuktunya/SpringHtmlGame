package com.test.project.repositories.entities

import jakarta.persistence.*

@Entity
class Survey(
    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: User,
    @Column(nullable = false, length = 256)
    var surveyMessage: String,
    @Column(nullable = false, length = 4)
    var surveyType: Byte
) : AbstractEntity()

enum class SurveyType {
    MULTI_ANSWER,
    FREE_ANSWER;
    val byte: Byte
        get() = this.ordinal.toByte()
    companion object{
        fun deByte(byte: Byte) = SurveyType.entries.first { it.ordinal==byte.toInt() }
    }
}