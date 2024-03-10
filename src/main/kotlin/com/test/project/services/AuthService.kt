package com.test.project.services

import com.test.project.model.request.UserRequest

interface AuthService {
    fun create(request: UserRequest): Boolean
}