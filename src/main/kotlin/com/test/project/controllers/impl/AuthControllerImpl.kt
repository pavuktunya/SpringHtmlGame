package com.test.project.controllers.impl

import com.test.project.controllers.AuthController
import com.test.project.model.message.*
import com.test.project.model.request.UserRequest
import com.test.project.services.JwtService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

//auth controller
@RestController
@RequestMapping("/api/auth")
class AuthControllerImpl(
    private val jwtService: JwtService,
) : AuthController {
    //registration of new users
    @PostMapping("/new")
    override fun createUser(@RequestBody request: UserRequest): AbstractApiMessage {
        return Message()
    }
    //get jwt token
    @PostMapping("/get_token")
    override fun getToken(@RequestBody request: UserRequest): AbstractApiMessage {
        val checkPair = jwtService.getToken(request)
        return TokenMessage(checkPair.second)
    }
}