package com.server.restful_polls.service.impl

import com.server.restful_polls.database.dao.UserDao
import com.server.restful_polls.database.entity.impl.User
import com.server.restful_polls.model.mapper.UserMapper
import com.server.restful_polls.model.request.UserRequest
import com.server.restful_polls.service.AuthService
import com.test.project.model.mapper.UserMapper
import com.test.project.model.request.UserRequest
import com.test.project.repositories.daos.UserDao
import com.test.project.repositories.entities.User
import com.test.project.services.AuthService
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class AuthServiceImpl(
    private val userDao: UserDao,
    private val userMapper: UserMapper
) : AuthService {
    @Transactional
    override fun create(request: UserRequest): Boolean {
        val existedUser: User? = userDao.findUserByEmail(request.email)
        if (existedUser != null) {
            return false
        } else {
            val newUser: User = userMapper.asEntity(request).also {
                //it.userRole = UserRole.ADMIN
                userDao.save(it)
            }
            return true
        }
    }
}