package com.test.project.controllers.examples

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class IndexController2 {
    @ResponseBody
    @GetMapping("/log")
    fun log(@RequestParam name: String, @RequestParam access: Access): String{
        return "Access for $name with the $access level is granted"
    }
}
enum class Access{
    ADMIN,
    USER
}