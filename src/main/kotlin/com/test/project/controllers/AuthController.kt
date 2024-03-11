package com.test.project.controllers

import com.test.project.model.message.AbstractApiMessage
import com.test.project.model.message.TokenMessage
import com.test.project.model.request.UserRequest

interface AuthController {
    fun getToken(request: UserRequest): TokenMessage
}