package com.test.project.controllers.examples

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SecurityController {
    @GetMapping
    fun index()="No secrets, sorry"
    @GetMapping("/admin")
    fun secret()="Secret message"
}