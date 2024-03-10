package com.test.project.model.message

import com.test.project.model.message.AbstractApiMessage

class DoesntExistedMessage : AbstractApiMessage() {
    override val message: String = "User isn't existed"
}