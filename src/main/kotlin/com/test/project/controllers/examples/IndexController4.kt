package com.test.project.controllers.examples

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

data class User(val name: String)

@Controller
class IndexController4 {
    @GetMapping("/enums")
    fun index(model: Model): String{
        val users = listOf(
            User("John"),
            User("Alex"),
            User("Kate")
        )
        model.addAttribute("users", users)
        return "index2"
    }
}