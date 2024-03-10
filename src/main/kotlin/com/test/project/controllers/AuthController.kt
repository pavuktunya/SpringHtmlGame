package com.test.project.controllers

import com.server.restful_polls.model.message.AbstractMessage
import com.server.restful_polls.model.request.UserRequest
import com.test.project.model.request.UserRequest

interface AuthController {
    fun createUser(request: UserRequest): AbstractMessage
    fun getToken(request: UserRequest): AbstractMessage
}