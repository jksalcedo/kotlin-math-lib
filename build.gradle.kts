plugins {
    kotlin("jvm") version "2.1.21"
    id("java-library")
    id("maven-publish")
}

group = "com.jksalcedo.math"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib:2.1.21")

}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(22)
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
        }
    }
}