package com.test.project.controllers.examples

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class IndexController3 {
    @GetMapping("/model")
    fun index(@RequestParam name: String, model: Model): String{
        model.addAttribute("name", name)
        return "index"
    }
}
@Controller
class IndexController10 {
    @GetMapping("/game")
    fun index(): String{
        return "index3"
    }
}