import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.2.3"
	id("io.spring.dependency-management") version "1.1.4"
	kotlin("jvm") version "1.9.22"
	kotlin("plugin.spring") version "1.9.22"
	kotlin("plugin.jpa") version "1.9.22"
}

group = "com.test"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	//Core
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	//Rust
	implementation("org.springframework.boot:spring-boot-starter-web")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	//Serialize/Des
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	//Thymeleaf
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	//Database
	//community dialect for sqlite and hibernate 6
	implementation("org.xerial:sqlite-jdbc:3.44.1.0")
	implementation("org.hibernate.orm:hibernate-community-dialects:6.4.4.Final")
//	runtimeOnly("com.mysql:mysql-connector-j")
//	implementation("mysql:mysql-connector-java:8.0.33")
	//implementation("org.hibernate:hibernate-core:5.5.8.Final")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	//security
	implementation("org.springframework.boot:spring-boot-starter-security")
	testImplementation("org.springframework.security:spring-security-test")
	implementation("io.jsonwebtoken:jjwt-api:0.12.3")
	implementation("io.jsonwebtoken:jjwt-impl:0.12.3")
	implementation("io.jsonwebtoken:jjwt-jackson:0.12.3")
	//developmentOnly("org.springframework.boot:spring-boot-docker-compose")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
