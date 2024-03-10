package com.test.project.controllers

import com.test.project.model.message.CheckMessage

interface CheckController {
    fun check(): CheckMessage
}