import org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
import org.gradle.api.tasks.testing.logging.TestLogEvent.*

plugins {
    kotlin("jvm") version "1.6.20"
}

group = "org.example"
version = "1.0-SNAPSHOT"

apply(plugin = "idea")
apply(plugin = "org.jetbrains.kotlin.jvm")

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.6.10")
    testImplementation("com.codeborne:selenide:6.3.5")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.2")
    testImplementation("org.assertj:assertj-core:3.22.0")
    implementation("io.github.microutils:kotlin-logging:2.1.21")
}

tasks.test {
    useJUnitPlatform()
    systemProperty("junit.jupiter.extensions.autodetection.enabled", true)
    systemProperty("junit.jupiter.testinstance.lifecycle.default", "per_class")
    testLogging {
        showStandardStreams = true
        events(
            PASSED,
            SKIPPED,
            FAILED,
            STARTED
        )
        showExceptions = true
        exceptionFormat = FULL
        showCauses = true
        showStackTraces = true
    }
}

tasks.wrapper {
    distributionType = Wrapper.DistributionType.ALL
    gradleVersion = "7.4"
}