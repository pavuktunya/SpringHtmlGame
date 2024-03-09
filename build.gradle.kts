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
	runtimeOnly("com.mysql:mysql-connector-j")
	implementation("mysql:mysql-connector-java:8.0.33")
	//implementation("org.hibernate:hibernate-core:5.5.8.Final")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	//security
	implementation("org.springframework.boot:spring-boot-starter-security")
	testImplementation("org.springframework.security:spring-security-test")
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
