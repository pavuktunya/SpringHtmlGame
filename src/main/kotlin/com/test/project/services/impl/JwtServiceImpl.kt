package com.test.project.services.impl

import com.test.project.components.jwt.JwtUtils
import com.test.project.model.request.UserRequest
import com.test.project.repositories.daos.UserDao
import com.test.project.repositories.entities.User
import com.test.project.services.JwtService
import org.springframework.stereotype.Service

@Service
class JwtServiceImpl(
    private val userDao: UserDao,
    private val jwtUtils: JwtUtils
) : JwtService {
    override fun getToken(request: UserRequest): Pair<Boolean, String> {
        val user: User? = userDao.findUserByEmail(request.email)
        return Pair(true, jwtUtils.generateToken(user!!))
    }
}