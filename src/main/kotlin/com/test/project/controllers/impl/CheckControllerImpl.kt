package com.test.project.controllers.impl

import com.server.restful_polls.controller.CheckController
import com.server.restful_polls.model.message.CheckMessage
import com.test.project.controllers.CheckController
import com.test.project.model.message.CheckMessage
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

//state check controller
@RestController
class CheckControllerImpl : CheckController {
    //check endpoint
    @GetMapping("/api/check")
    override fun check(): CheckMessage = CheckMessage()
}