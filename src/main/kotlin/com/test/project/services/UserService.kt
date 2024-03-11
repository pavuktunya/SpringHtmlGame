package com.test.project.services

import com.test.project.model.request.UserRequest
import com.test.project.model.response.UserResponse
import org.springframework.security.core.userdetails.UserDetailsService

interface UserService: UserDetailsService {
    fun list(): List<UserResponse>
    fun getById(id: Long): UserResponse
    fun getByEmail(email: String): UserResponse
    fun create(request: UserRequest): UserResponse
    fun update(id: Long, request: UserRequest): UserResponse
    fun delete(id: Long)
}