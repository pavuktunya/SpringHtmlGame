//package com.test.project.controllers.examples
//
//import org.springframework.stereotype.Controller
//import org.springframework.web.bind.annotation.GetMapping
//import org.springframework.web.bind.annotation.ResponseBody
//import org.springframework.web.bind.annotation.RestController
//
//@Controller
//class IndexControllerResponse {
//    @ResponseBody //возвращаемый методом ответ сериализуется в тело ответа
//    @GetMapping("/response")
//    fun index() = User("Kate")
//}
//
//@RestController
//class IndexControllerResponse2{
//    @GetMapping("/response2")
//    fun index() = User("Jack Shekspir")
//}

//@RestController это @Controller и @ResponseBody для каждого метода этого класса