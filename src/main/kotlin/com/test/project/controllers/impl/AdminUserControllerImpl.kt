package com.test.project.controllers.impl

import com.test.project.controllers.AdminUserController
import com.test.project.model.request.UserRequest
import com.test.project.model.response.UserResponse
import com.test.project.services.UserService
import org.springframework.web.bind.annotation.*

//admin controller for users management
@RestController
@RequestMapping("/api/admin/user")
class AdminUserControllerImpl (
    private val adminUserService: UserService,
) : AdminUserController {
    @GetMapping
    override fun list(): List<UserResponse> = adminUserService.list()

    //find user data by id
    @GetMapping("/{id}")
    override fun getUserById(@PathVariable id: Long): UserResponse = adminUserService.getUserById(id)

    //update user data
    @PutMapping("/{id}")
    override fun updateUser(@PathVariable id: Long, @RequestBody request: UserRequest): UserResponse =
        adminUserService.updateUser(id, request)

    //delete user data
    @DeleteMapping("/{id}")
    override fun deleteUser(@PathVariable id: Long): DeleteMessage {
        adminUserService.deleteUser(id)
        return DeleteMessage("User")
    }
}

