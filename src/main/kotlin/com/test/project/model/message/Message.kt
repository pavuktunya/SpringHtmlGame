package com.test.project.model.message

class Message(subj: String) : AbstractApiMessage() {
    override val message: String = "$subj created"
}