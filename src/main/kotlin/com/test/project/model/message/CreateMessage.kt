package com.test.project.model.message

import com.test.project.model.message.AbstractApiMessage

class CreateMessage : AbstractApiMessage() {
    override val message: String = "User created"
}