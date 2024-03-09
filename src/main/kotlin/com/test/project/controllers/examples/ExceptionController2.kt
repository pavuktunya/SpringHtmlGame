package com.test.project.controllers.examples

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/exec2")
class ExceptionController2 {
    private val users = listOf(
        User("Kate"),
        User("John")
    )
    @GetMapping("/{id}")
    fun get(@PathVariable id: Int) = users[id]

    @ExceptionHandler(IndexOutOfBoundsException::class)
    fun handleIndexOutOfBoundsException(exc: IndexOutOfBoundsException) = mapOf("error" to exc.message)
}