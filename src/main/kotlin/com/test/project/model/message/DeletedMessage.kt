package com.test.project.model.message

class DeletedMessage(subj: String) : AbstractApiMessage() {
    override val message: String = "$subj deleted"
}