package com.test.project.controllers.impl

import com.test.project.controllers.UserController
import com.test.project.model.message.DeletedMessage
import com.test.project.model.request.UserRequest
import com.test.project.model.response.UserResponse
import com.test.project.services.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserControllerImpl(
    private val service: UserService
) : UserController {
    @GetMapping
    override fun list(): List<UserResponse> = service.list()
    @GetMapping("/{id}")
    override fun getById(@PathVariable id: Long): UserResponse = service.getById(id)
    @PostMapping
    override fun create(@RequestBody request: UserRequest): UserResponse = service.create(request)
    @PutMapping("/{id}")
    override fun update(@PathVariable id: Long,@RequestBody request: UserRequest): UserResponse = service.update(id, request)
    @DeleteMapping("/{id}")
    override fun delete(@PathVariable id: Long): DeletedMessage {
        service.delete(id)
        return DeletedMessage()
    }
}