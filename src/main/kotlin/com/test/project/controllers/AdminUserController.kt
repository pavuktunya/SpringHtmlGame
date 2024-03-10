package com.test.project.controllers

import com.server.restful_polls.model.message.DeleteMessage
import com.server.restful_polls.model.request.UserRequest
import com.server.restful_polls.model.response.UserResponse

interface AdminUserController {
    fun list(): List<UserResponse>
    fun getUserById(id: Long): UserResponse
    fun updateUser(id: Long, request: UserRequest): UserResponse
    fun deleteUser(id: Long): DeleteMessage
}