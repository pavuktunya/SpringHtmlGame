package com.test.project.model.message

class TokenMessage(token: String) : AbstractApiMessage() {
    override val message: String = token
}