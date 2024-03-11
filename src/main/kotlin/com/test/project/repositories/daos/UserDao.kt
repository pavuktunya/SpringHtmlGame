package com.test.project.repositories.daos

import com.test.project.repositories.entities.User

interface UserDao: CommonDao<User>{
    fun findUserByEmail(email: String): User?
    fun findUserByName(name: String): User?
}