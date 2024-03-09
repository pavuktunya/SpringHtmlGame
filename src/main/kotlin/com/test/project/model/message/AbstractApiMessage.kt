package com.test.project.model.message

import com.test.project.model.ApiResponse
import org.springframework.http.HttpStatus

abstract class AbstractApiMessage: ApiResponse {
    override val status: HttpStatus = HttpStatus.OK
}