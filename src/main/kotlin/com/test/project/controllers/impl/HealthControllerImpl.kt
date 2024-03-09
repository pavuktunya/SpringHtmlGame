package com.test.project.controllers.impl

import com.test.project.controllers.HealthController
import com.test.project.model.message.HealthMessage
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HealthControllerImpl : HealthController {
    @GetMapping("/health")
    override fun health(): HealthMessage = HealthMessage()
}