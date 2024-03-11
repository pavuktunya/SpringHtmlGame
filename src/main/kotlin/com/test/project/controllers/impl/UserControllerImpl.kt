package com.test.project.controllers.impl

import com.test.project.model.message.DeletedMessage
import com.test.project.model.request.UserRequest
import com.test.project.model.response.UserResponse
import com.test.project.services.UserService
import org.springframework.web.bind.annotation.*

//admin controller for users management
@RestController
@RequestMapping("/api/admin/user")
class UserControllerImpl (
    private val adminUserService: UserService,
) : AdminUserController {
    @GetMapping
    override fun list(): List<UserResponse> = adminUserService.list()

    //find user data by id
    @GetMapping("/{id}")
    override fun getUserById(@PathVariable id: Long): UserResponse = adminUserService.getById(id)

    //update user data
    @PutMapping("/{id}")
    override fun updateUser(@PathVariable id: Long, @RequestBody request: UserRequest): UserResponse =
        adminUserService.update(id, request)

    //delete user data
    @DeleteMapping("/{id}")
    override fun deleteUser(@PathVariable id: Long): DeletedMessage {
        adminUserService.delete(id)
        return DeletedMessage("User")
    }
}

