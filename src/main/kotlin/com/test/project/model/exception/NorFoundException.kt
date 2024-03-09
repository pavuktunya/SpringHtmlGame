package com.test.project.model.exception

import org.springframework.http.HttpStatus

class NorFoundException: AbstractApiException() {
    override val status: HttpStatus = HttpStatus.NOT_FOUND
    override val message: String = "Not found"
}