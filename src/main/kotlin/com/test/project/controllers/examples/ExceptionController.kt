//package com.test.project.controllers.examples
//
//import org.springframework.http.HttpStatus
//import org.springframework.web.bind.annotation.GetMapping
//import org.springframework.web.bind.annotation.PathVariable
//import org.springframework.web.bind.annotation.RequestMapping
//import org.springframework.web.bind.annotation.ResponseStatus
//import org.springframework.web.bind.annotation.RestController
//
//@ResponseStatus(value = HttpStatus.NOT_FOUND)
//class ResourseNotFound: Exception()
//
//@RestController
//@RequestMapping("/exec")
//class ExceptionController {
//    private val users = listOf(
//        User("Kate"),
//        User("Jane")
//    )
//    @GetMapping("/{id}")
//    fun get(@PathVariable id: Int) = try {
//        users[id]
//    } catch (e: IndexOutOfBoundsException){
//        throw ResourseNotFound()
//    }
//}