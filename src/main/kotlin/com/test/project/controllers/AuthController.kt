package com.test.project.controllers

import com.test.project.model.message.AbstractApiMessage
import com.test.project.model.request.UserRequest

interface AuthController {
    fun createUser(request: UserRequest): AbstractApiMessage
    fun getToken(request: UserRequest): AbstractApiMessage
}