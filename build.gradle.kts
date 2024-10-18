plugins {
    kotlin("jvm") version "2.0.20"
    id("io.ktor.plugin") version "3.0.0"

    kotlin("plugin.serialization") version "1.6.10"
}

group = "org.example"
version = "1.0-SNAPSHOT"



repositories {
    mavenCentral()
}
application {
    mainClass.set("org.example.serverlessktKtor.ApplicationKt")
}

dependencies {
    testImplementation(kotlin("test"))

    val ktorVersion = "3.0.0"

    implementation("io.ktor:ktor-server-core:$ktorVersion")
    implementation("io.ktor:ktor-server-netty:$ktorVersion")
    implementation("ch.qos.logback:logback-classic:1.5.11")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
    implementation("io.ktor:ktor-client-core:$ktorVersion")
    implementation("io.ktor:ktor-client-cio:$ktorVersion")
    implementation("io.ktor:ktor-client-serialization:$ktorVersion")
    implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
    implementation("io.ktor:ktor-server-content-negotiation:$ktorVersion")
}

tasks.test {
    useJUnitPlatform()
}