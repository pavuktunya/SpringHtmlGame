package com.test.project.repositories.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity

@Entity
class User(
    @Column(nullable = false, length = 125)
    var name: String,
    @Column(nullable = false, length = 125)
    var email: String,
    @Column(nullable = false, length = 125)
    var password: String,
    @Column(nullable=false, length = 4)
    var role: Byte
): AbstractEntity()

enum class USER_ROLES{
    ADMIN, USER;
    val byte: Byte
        get() = this.ordinal.toByte()
    companion object{
        fun deByte(byte: Byte) = USER_ROLES.entries.first { it.ordinal==byte.toInt() }
    }
}