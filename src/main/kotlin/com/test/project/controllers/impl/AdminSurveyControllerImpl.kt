package com.test.project.controllers.impl

import com.test.project.controllers.AdminSurveyController
import com.test.project.model.request.SurveyRequest
import com.test.project.model.response.SurveyResponse
import com.test.project.services.SurveyService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/admin/survey")
class AdminSurveyControllerImpl (
    private val adminSurveyService: SurveyService,
) : AdminSurveyController {
    @GetMapping
    override fun list(): List<SurveyResponse> = adminSurveyService.list()

    @GetMapping("/{id}")
    override fun findSurveyById(@PathVariable id: Long): SurveyResponse =
        adminSurveyService.findSurveyById(id)

    @PostMapping
    override fun createSurvey(@RequestBody request: SurveyRequest): SurveyResponse {
        return adminSurveyService.createSurvey(request)
    }

    @PutMapping("/{id}")
    override fun startStopSurvey(@PathVariable id: Long, @RequestBody flag: Boolean): SurveyResponse =
        adminSurveyService.startStopSurvey(id, flag)

    @DeleteMapping("/{id}")
    override fun deleteSurvey(@PathVariable id: Long): DeleteMessage {
        adminSurveyService.deleteSurvey(id)
        return DeleteMessage("Survey")
    }
}