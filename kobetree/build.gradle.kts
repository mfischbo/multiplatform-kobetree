import org.gradle.internal.classpath.Instrumented.systemProperty

plugins {
    `maven-publish`
    `java-library`
    kotlin("jvm") version "2.2.20"
}

group = "com.rakangsoftware.kobetree"
version = "0.1.1"

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test:2.2.20")
}

publishing {
    publications {
        create<MavenPublication>("mavenKotlin") {
            from(components["java"])
        }
    }
    repositories {
        mavenLocal()
    }
}


kotlin {
    jvmToolchain(17)
    sourceSets.main {
        kotlin.srcDirs("src/commonMain/kotlin")
    }
    sourceSets.test {
        kotlin.srcDirs("src/commonTest/kotlin")
    }
}

java {
    withSourcesJar()
}