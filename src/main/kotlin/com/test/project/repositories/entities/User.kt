package com.test.project.repositories.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity

@Entity
class User(
    @Column(nullable = false, length = 250)
    var name: String,
    @Column(nullable = false, length = 125)
    var email: String,
    @Column(nullable = false, length = 125)
    var password: String
): AbstractEntity()