package com.test.project.controllers

import com.test.project.model.message.DeletedMessage
import com.test.project.model.request.UserRequest
import com.test.project.model.response.UserResponse

interface UserController {
    fun list(): List<UserResponse>
    fun getById(id: Long): UserResponse
    fun create(request: UserRequest): UserResponse
    fun update(id: Long, request: UserRequest): UserResponse
    fun delete(id: Long): DeletedMessage
}