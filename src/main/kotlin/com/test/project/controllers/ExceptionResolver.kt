package com.test.project.controllers

import com.test.project.model.ApiResponse
import com.test.project.model.exception.AbstractApiException
import com.test.project.model.message.AbstractApiMessage
import org.springframework.http.HttpStatus
import org.springframework.http.RequestEntity
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest

@ControllerAdvice
class ExceptionResolver {
    @ExceptionHandler(value = [AbstractApiException::class])
    fun handle(cause: AbstractApiException, request: WebRequest): ResponseEntity<ApiResponse>{
        return cause.asResponse()
    }
}