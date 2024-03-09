package com.test.project.controllers

import com.test.project.model.message.HealthMessage

interface HealthController {
    fun health(): HealthMessage
}