package com.test.project.controllers.impl

import com.server.restful_polls.controller.SurveyController
import com.server.restful_polls.model.message.AnswerMessage
import com.server.restful_polls.model.request.AnswerRequest
import com.server.restful_polls.model.response.SurveyUserVersion
import com.server.restful_polls.service.SurveyService
import com.test.project.controllers.SurveyController
import com.test.project.services.SurveyService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/survey")
class SurveyControllerImpl (
    private val surveyService: SurveyService
) : SurveyController {
    @GetMapping
    override fun getSurveyList(): List<SurveyUserVersion> =
        surveyService.getSurveyList()

    @PostMapping("/{id}")
    override fun giveAnswer(@PathVariable id: Long, @RequestBody answerRequest: AnswerRequest): AnswerMessage {
        surveyService.giveAnswer(id, answerRequest)
        return AnswerMessage()
    }
}