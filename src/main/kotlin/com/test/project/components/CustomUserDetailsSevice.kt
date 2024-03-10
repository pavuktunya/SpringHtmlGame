package com.test.project.components

import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component
import java.util.Base64.getEncoder

@Component
class CustomUserDetailsSevice (
    private val encoder: PasswordEncoder
): UserDetailsService{
    val users:List<UserDetails> = listOf(
        User.builder()
        .username("user")
        .password(encoder.encode("password"))
        .roles("USER")
        .build(),
    User.builder()
        .username("admin")
        .password(encoder.encode("secret"))
        .roles("ADMIN")
        .build()
    )
    override fun loadUserByUsername(username: String?): UserDetails? {
        return users.firstOrNull{ it.username == username}
    }
}