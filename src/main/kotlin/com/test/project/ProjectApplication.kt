package com.test.project

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.reactive.result.view.MustacheViewResolver
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.core.io.ResourceLoader
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.servlet.ViewResolver


@EnableAutoConfiguration
@SpringBootApplication
class ProjectApplication: ApplicationRunner{
	@Autowired
	lateinit var context: ApplicationContext
	@Autowired
	lateinit var encoder: PasswordEncoder
	override fun run(args: ApplicationArguments?) {
//		val beans = context.beanDefinitionNames
//		//beans.forEach { println(it) }
//		val hash = encoder.encode("password")
//		println(hash)
//		println(encoder.matches("password", hash))
	}
}
fun main(args: Array<String>) {
	runApplication<ProjectApplication>(*args)
}

