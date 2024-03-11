package com.test.project.controllers.impl

import com.test.project.controllers.SurveyController
import com.test.project.model.message.DeletedMessage
import com.test.project.model.message.Message
import com.test.project.model.request.AnswerRequest
import com.test.project.model.request.SurveyRequest
import com.test.project.model.response.SurveyResponse
import com.test.project.repositories.entities.Survey
import com.test.project.services.SurveyService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/survey")
class SurveyControllerImpl (
    private val surveyService: SurveyService
) : SurveyController {
    @PostMapping
    override fun createSurvey(@RequestBody request: SurveyRequest): SurveyResponse {
        return surveyService.create(request)
    }
    @GetMapping
    override fun list(): List<SurveyResponse> = surveyService.list()
    @PostMapping("/{id}")
    override fun giveAnswer(@PathVariable id: Long, @RequestBody answerRequest: AnswerRequest): Message {
        surveyService.giveAnswer(id, answerRequest)
        return Message("Answer")
    }
    @GetMapping("/{id}")
    override fun findSurveyById(@PathVariable id: Long): SurveyResponse =
        surveyService.getById(id)
    @DeleteMapping("/{id}")
    override fun deleteSurvey(@PathVariable id: Long): DeletedMessage {
        surveyService.delete(id)
        return DeletedMessage("Survey")
    }
}