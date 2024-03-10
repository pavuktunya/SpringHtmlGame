package com.test.project.services

import com.test.project.model.request.UserRequest
import com.test.project.model.response.UserResponse

interface UserService {
    fun list(): List<UserResponse>
    fun getById(id: Long): UserResponse
    fun getByEmail(email: String): UserResponse
    fun create(request: UserRequest): UserResponse
    fun update(id: Long, request: UserRequest): UserResponse
    fun delete(id: Long)
}