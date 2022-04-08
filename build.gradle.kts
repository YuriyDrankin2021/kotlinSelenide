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
}

tasks.test {
    useJUnitPlatform()
    systemProperty("junit.jupiter.extensions.autodetection.enabled", true)
    systemProperty("junit.jupiter.testinstance.lifecycle.default", "per_class")
}

tasks.wrapper {
    distributionType = Wrapper.DistributionType.ALL
    gradleVersion = "7.3"
}