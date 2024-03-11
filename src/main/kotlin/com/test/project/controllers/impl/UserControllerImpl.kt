package com.test.project.controllers.impl

import com.test.project.controllers.UserController
import com.test.project.model.message.DeletedMessage
import com.test.project.model.request.UserRequest
import com.test.project.model.response.UserResponse
import com.test.project.services.UserService
import org.springframework.web.bind.annotation.*

//admin controller for users management
@RestController
class UserControllerImpl (
    private val userService: UserService
) : UserController {
    @GetMapping("/api/auth/user")
    override fun list(): List<UserResponse> = userService.list()
    @PostMapping("/api/admin/user")
    override fun create(request: UserRequest): UserResponse = userService.create(request)
    //find user data by id
    @GetMapping("/api/admin/user/{id}")
    override fun getById(@PathVariable id: Long): UserResponse = userService.getById(id)
    //update user data
    @PutMapping("/api/admin/user/{id}")
    override fun update(@PathVariable id: Long, @RequestBody request: UserRequest)
    : UserResponse = userService.update(id, request)
    //delete user data
    @DeleteMapping("/api/admin/user/{id}")
    override fun delete(@PathVariable id: Long): DeletedMessage {
        userService.delete(id)
        return DeletedMessage("User")
    }
}

