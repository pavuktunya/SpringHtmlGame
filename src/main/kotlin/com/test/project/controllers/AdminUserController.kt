package com.test.project.controllers


import com.test.project.model.message.DeletedMessage
import com.test.project.model.request.UserRequest
import com.test.project.model.response.UserResponse

interface AdminUserController {
    fun list(): List<UserResponse>
    fun getUserById(id: Long): UserResponse
    fun updateUser(id: Long, request: UserRequest): UserResponse
    fun deleteUser(id: Long): DeletedMessage
}