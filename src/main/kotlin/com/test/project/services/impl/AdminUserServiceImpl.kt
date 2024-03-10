package com.server.restful_polls.service.impl

import com.test.project.model.mapper.UserMapper
import com.test.project.model.request.UserRequest
import com.test.project.model.response.UserResponse
import com.test.project.repositories.daos.UserDao
import com.test.project.services.UserService
import jakarta.transaction.Transactional
import org.springframework.data.jpa.repository.Modifying
import org.springframework.stereotype.Service

@Service
class AdminUserServiceImpl(
    private val userDao: UserDao,
    private val userMapper: UserMapper
) : UserService {
    override fun list(): List<UserResponse> {
        val users = userDao.findAll()
        return users.map { userMapper.asResponse(it) }
    }

    override fun getUserById(entityId: Long): UserResponse {
        val user = userDao.findUserByEntityId(entityId) ?: throw Exception("Not found")
        return userMapper.asResponse(user)
    }

    @Transactional
    override fun createUser(request: UserRequest): UserResponse {
        val user = userMapper.asEntity(request).also { userDao.save(it) }
        return userMapper.asResponse(user)
    }

    @Transactional
    @Modifying
    override fun updateUser(entityId: Long, request: UserRequest): UserResponse {
        val user = userDao.findUserByEntityId(entityId) ?: throw Exception("Not found")
        val updated =  userMapper.update(user, request)
        return userMapper.asResponse(updated)
    }

    @Transactional
    @Modifying
    override fun deleteUser(entityId: Long) {
        val user = userDao.findUserByEntityId(entityId) ?: throw Exception("Not found")
        userDao.delete(user)
    }
}