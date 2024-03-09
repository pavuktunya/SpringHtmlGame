package com.test.project.repositories.daos

import com.test.project.repositories.entities.AbstractEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.NoRepositoryBean
import org.springframework.data.repository.PagingAndSortingRepository

@NoRepositoryBean
interface CommonDao<T: AbstractEntity>: CrudRepository<T, Long>{
    fun findEntityById(id: Long): T?
}