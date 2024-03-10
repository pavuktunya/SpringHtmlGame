package com.test.project.controllers

import com.server.restful_polls.model.message.CheckMessage
import com.test.project.model.message.CheckMessage

interface CheckController {
    fun check(): CheckMessage
}