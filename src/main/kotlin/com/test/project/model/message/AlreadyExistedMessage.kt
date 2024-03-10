package com.test.project.model.message

import com.test.project.model.message.AbstractApiMessage

class AlreadyExistedMessage : AbstractApiMessage() {
    override val message: String = "User has already existed"
}