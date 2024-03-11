package com.test.project.repositories.daos

import com.test.project.repositories.entities.Survey

interface SurveyDao: CommonDao<Survey>{
    fun findSurveysByUserId(id: Long): List<Survey>
}