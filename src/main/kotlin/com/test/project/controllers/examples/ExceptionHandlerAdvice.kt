//package com.test.project.controllers.examples
//
//import org.springframework.http.HttpStatus
//import org.springframework.http.ResponseEntity
//import org.springframework.web.bind.annotation.ControllerAdvice
//import org.springframework.web.bind.annotation.ExceptionHandler
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
//
//@ControllerAdvice
//class ExceptionHandlerAdvice: ResponseEntityExceptionHandler()
//{
//    @ExceptionHandler(IndexOutOfBoundsException::class)
//    fun handleIndexOutOfBoundsException(exc: IndexOutOfBoundsException): ResponseEntity<Map<String, String?>>{
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mapOf("errorHandler" to exc.message ))
//    }
//}