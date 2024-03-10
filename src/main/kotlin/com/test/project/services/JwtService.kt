package com.test.project.services

import com.test.project.model.request.UserRequest

interface JwtService {
    fun getToken(request: UserRequest): Pair<Boolean, String>
}