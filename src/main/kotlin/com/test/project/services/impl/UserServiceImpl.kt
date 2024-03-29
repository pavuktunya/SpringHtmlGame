package com.test.project.services.impl

import com.test.project.model.mapper.UserMapper
import com.test.project.model.request.UserRequest
import com.test.project.model.response.UserResponse
import com.test.project.repositories.daos.UserDao
import com.test.project.repositories.entities.USER_ROLES
import com.test.project.services.UserService
import jakarta.transaction.Transactional
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.data.jpa.repository.Modifying
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    private val dao: UserDao,
    private val mapper: UserMapper
) : UserService {
    override fun list(): List<UserResponse> {
        val users = dao.findAll()
        return mapper.asListResponse(users)
    }
    override fun getById(id: Long): UserResponse {
        val user = dao.findEntityById(id) ?: throw NotFoundException()
        return mapper.asResponse(user)
    }
    override fun getByEmail(email: String): UserResponse {
        val user = dao.findUserByEmail(email) ?: throw NotFoundException()
        return mapper.asResponse(user)
    }
    //либо выполнится полностью, либо ничего
    @Transactional
    override fun create(request: UserRequest): UserResponse {
        val user = mapper.asEntity(request).apply { dao.save(this) }
        return mapper.asResponse(user)
    }
    @Transactional
    @Modifying //т.к. изменяет сущность в бд
    override fun update(id: Long, request: UserRequest): UserResponse {
        val user = dao.findEntityById(id) ?: throw NotFoundException()
        val updated = mapper.update(user, request)
        return mapper.asResponse(updated)
    }
    @Transactional
    @Modifying
    override fun delete(id: Long) {
        val user = dao.findEntityById(id) ?: throw NotFoundException()
        dao.delete(user)
    }
    override fun loadUserByUsername(email: String): UserDetails {
        val user = dao.findUserByEmail(email)!!
        val role = USER_ROLES.deByte(user.role).name.uppercase()
        return User(user.name, user.password, listOf(SimpleGrantedAuthority("ROLE_$role")))
    }
}