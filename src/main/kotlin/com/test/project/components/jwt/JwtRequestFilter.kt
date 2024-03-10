package com.test.project.components.jwt

import com.server.restful_polls.service.impl.UserDetailsServiceImpl
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
    private val userDetailsService: UserDetailsServiceImpl,
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
            val userDetails = userDetailsService.loadUserByUsername(email)
            if (userDetails != null && jwtUtils.validateToken(token, userDetails)) {
                val authentication = UsernamePasswordAuthenticationToken(
                    userDetails, "", userDetails.authorities
                )
                authentication.details = WebAuthenticationDetailsSource().buildDetails(request)
                SecurityContextHolder.getContext().authentication = authentication
                println(authentication.authorities)
            }
        }
        filterChain.doFilter(request, response)
    }
}