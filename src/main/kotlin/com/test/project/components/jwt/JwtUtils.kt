package com.test.project.components.jwt

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import java.util.*
import javax.crypto.SecretKey

@Component
class JwtUtils {
    //generate secretKey from secretString
    private val secretString: String = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE0ODUxNDA5ODQsImlhdCI6MTQ4N" +
            "TEzNzM4NCwiaXNzIjoiYWNtZS5jb20iLCJzdWIiOiIyOWFjMGMxOC0wYjRhLTQyY2YtODJmYy0wM2Q1NzAzMThhMWQiLCJhcHBsaW"
    private val secretKey: SecretKey = Keys.hmacShaKeyFor(secretString.toByteArray())
    //~10 day duration
    private val expirationTime: Long = 864_000_000

    //generate token
    fun generateToken(userDetails: UserDetails): String {
        return Jwts.builder()
            .subject(userDetails.username)
            .issuedAt(Date())
            .expiration(Date(System.currentTimeMillis() + expirationTime))
            .signWith(secretKey)
            .compact()
    }

    //validate token
    fun validateToken(token: String, userDetails: UserDetails): Boolean {
        return extractEmail(token) == userDetails.username && !isTokenExpired(token)
    }

    //load email from payload
    fun extractEmail(token: String): String {
        return Jwts.parser()
            .verifyWith(secretKey)
            .build()
            .parseSignedClaims(token)
            .payload
            .subject
    }

    //check that token not is expired
    fun isTokenExpired(token: String): Boolean {
        return Jwts.parser()
            .verifyWith(secretKey)
            .build()
            .parseSignedClaims(token)
            .payload
            .expiration
            .before(Date())
    }
}