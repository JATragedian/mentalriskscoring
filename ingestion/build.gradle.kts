plugins {
    id("org.springframework.boot") version "4.0.5"
    id("io.spring.dependency-management") version "1.1.7"
}

dependencies {
    implementation(project(":contracts"))

    implementation("org.springframework.boot:spring-boot-starter-kafka")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("com.fasterxml.jackson.core:jackson-databind")
    implementation("io.confluent:kafka-avro-serializer:8.2.0")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}