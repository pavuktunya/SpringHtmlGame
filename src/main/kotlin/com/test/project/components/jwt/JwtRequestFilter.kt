package com.test.project.components.jwt

import com.test.project.services.UserService
import com.test.project.services.impl.UserServiceImpl
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class JwtRequestFilter(
    private val jwtUtils: JwtUtils,
    private val userService: UserService
) : OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val header = request.getHeader("Authorization")
        var email: String? = null
        var token: String? = null
        if (header != null && header.startsWith("Bearer ")) {
            //handle taking token from authorization header
            token = header.substring(7)
            email = jwtUtils.extractEmail(token)
        }
        if (token != null && email!= null && SecurityContextHolder.getContext().authentication == null) {
            val user = userService.getByEmail(email)
            if (jwtUtils.validateToken(token, user.name)) {
                val authentication = UsernamePasswordAuthenticationToken(
                    user, "", null
                )
                authentication.details = WebAuthenticationDetailsSource().buildDetails(request)
                SecurityContextHolder.getContext().authentication = authentication
                println(authentication.authorities)
            }
        }
        filterChain.doFilter(request, response)
    }
}