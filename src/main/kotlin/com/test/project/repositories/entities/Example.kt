package com.test.project.repositories.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EntityManager
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Entity
class Example(
    @Column
    var name: String
):AbstractEntity()

@Repository
interface ExampleDao: CrudRepository<Example, Int>