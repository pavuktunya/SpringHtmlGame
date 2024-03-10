package com.test.project.model.message

class AnswerMessage (
    override val message: String = "Answer has sent"
) : AbstractApiMessage()