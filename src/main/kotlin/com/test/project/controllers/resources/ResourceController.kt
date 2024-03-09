package com.test.project.controllers.resources

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.ResponseBody
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

//@Controller
//class ResourceController {
//    @GetMapping("/styles/css/{code}.css")
//    @ResponseBody
//    @Throws(IOException::class)
//    fun styles(@PathVariable("code") code: String): ResponseEntity<String> {
//        // получаем содержимое файла из папки ресурсов в виде потока
//        val `is` = javaClass.classLoader.getResourceAsStream("static/css/$code.css")
//        // преобразуем поток в строку
//        val bf = BufferedReader(InputStreamReader(`is`))
//        val sb = StringBuffer()
//        var line: String? = null
//        while ((bf.readLine().also { line = it }) != null) {
//            sb.append(line + "\n")
//        }
//        // создаем объект, в котором будем хранить HTTP заголовки
//        val httpHeaders: HttpHeaders = HttpHeaders()
//        // добавляем заголовок, который хранит тип содержимого
//        httpHeaders.add("Content-Type", "text/css; charset=utf-8")
//        // возвращаем HTTP ответ, в который передаем тело ответа, заголовки и статус 200 Ok
//        return ResponseEntity(sb.toString(), httpHeaders, HttpStatus.OK)
//    }
//}