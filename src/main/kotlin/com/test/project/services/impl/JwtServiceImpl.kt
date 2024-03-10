package com.server.restful_polls.service.impl

import com.server.restful_polls.database.dao.UserDao
import com.server.restful_polls.database.entity.impl.User
import com.server.restful_polls.model.jwt.JwtUtils
import com.server.restful_polls.model.request.UserRequest
import com.server.restful_polls.service.JwtService
import org.springframework.stereotype.Service

@Service
class JwtServiceImpl(
    private val userDao: UserDao,
    private val userDetailsService: UserDetailsServiceImpl,
    private val jwtUtils: JwtUtils
) : JwtService {
    override fun getToken(request: UserRequest): Pair<Boolean, String> {
        val user: User? = userDao.findUserByEmail(request.email)
        if (user != null) {
            val userDetails = userDetailsService.loadUserByUsername(user.email)
            return Pair(true, jwtUtils.generateToken(userDetails!!))
        } else {
            return Pair(false, "")
        }
    }
}