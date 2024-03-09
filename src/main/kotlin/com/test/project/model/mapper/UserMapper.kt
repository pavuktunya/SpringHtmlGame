package com.test.project.model.mapper

import com.test.project.model.request.UserRequest
import com.test.project.model.response.UserResponse
import com.test.project.repositories.entities.User
import org.springframework.stereotype.Component

@Component
class UserMapper {
    fun asEntity(request: UserRequest) = User(
        name = request.name,
        email = request.email
    )
    fun asResponse(user: User) = UserResponse(
        id = user.id,
        createdAt = user.createdAt,
        name = user.name,
        email = user.email
    )
    fun update(user: User, request: UserRequest): User{
        user.name = request.name
        user.email = request.email
        return user
    }
    fun asListResponse(users: Iterable<User>) = users.map { asResponse(it) }
}