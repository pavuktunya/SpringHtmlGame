package com.test.project.controllers.impl

import com.test.project.controllers.AuthController
import com.test.project.model.message.AlreadyExistedMessage
import com.test.project.model.message.CreateMessage
import com.test.project.model.message.DoesntExistedMessage
import com.test.project.model.message.TokenMessage
import com.test.project.model.request.UserRequest
import com.test.project.services.AuthService
import com.test.project.services.JwtService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

//auth controller
@RestController
@RequestMapping("/api/auth")
class AuthControllerImpl(
    private val authService: AuthService,
    private val jwtService: JwtService,
) : AuthController {
    //registration of new users
    @PostMapping("/new")
    override fun createUser(@RequestBody request: UserRequest): AbstractMessage {
        return if (authService.create(request))
            CreateMessage()
        else
            AlreadyExistedMessage()
    }

    //get jwt token
    @PostMapping("/get_token")
    override fun getToken(@RequestBody request: UserRequest): AbstractMessage {
        val checkPair = jwtService.getToken(request)
        return if (checkPair.first) {
            TokenMessage(checkPair.second)
        } else {
            DoesntExistedMessage()
        }
    }
}