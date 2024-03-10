package com.server.restful_polls.service.impl

import com.test.project.repositories.daos.UserDao
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserDetailsServiceImpl(
    private val userDao: UserDao
) : UserDetailsService {
    override fun loadUserByUsername(email: String): UserDetails? {
        val user = userDao.findUserByEmail(email) ?: throw Exception("Not found")
        return User(
            user.email,
            user.password,
            listOf(SimpleGrantedAuthority("ROLE_${user.userRole.name}"))
        )
    }
}