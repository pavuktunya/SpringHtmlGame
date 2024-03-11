package com.test.project.controllers.impl

import com.test.project.controllers.AuthController
import com.test.project.model.message.*
import com.test.project.model.request.UserRequest
import com.test.project.services.impl.JwtServiceImpl
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

//auth controller
@RestController
@RequestMapping("/api/auth")
class AuthControllerImpl(
    private val jwtService: JwtServiceImpl
) : AuthController {
    //get jwt token
    @PostMapping("/get_token")
    override fun getToken(@RequestBody request: UserRequest): TokenMessage {
        val checkPair = jwtService.getToken(request)
        return TokenMessage(checkPair.second)
    }
}