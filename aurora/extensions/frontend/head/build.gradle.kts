import io.gitlab.arturbosch.detekt.Detekt

plugins {
    kotlin("multiplatform") version "1.9.10"
    id("io.gitlab.arturbosch.detekt") version "1.23.4"
    id("maven-publish")
}

group = "maack.aurora"
version = "1.0.0"

repositories {
    mavenCentral()
    mavenLocal()
}

kotlin {
    explicitApi()
    val hostOs = System.getProperty("os.name")
    val isArm64 = System.getProperty("os.arch") == "aarch64"
    val isMingwX64 = hostOs.startsWith("Windows")
    val nativeTarget = when {
        hostOs == "Mac OS X" && isArm64 -> macosArm64("native")
        hostOs == "Mac OS X" && !isArm64 -> macosX64("native")
        hostOs == "Linux" && isArm64 -> linuxArm64("native")
        hostOs == "Linux" && !isArm64 -> linuxX64("native")
        isMingwX64 -> mingwX64("native")
        else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("maack.aurora:page:1.0.0")
            }
        }
        val commonTest by getting
        val nativeMain by getting
        val nativeTest by getting
    }
}

detekt {
    source.setFrom("src/commonMain/kotlin")
    allRules = true
    config.setFrom("$projectDir/config/detekt.yml")
    parallel = true
}
tasks.withType<Detekt>().configureEach {
    reports {
        html.required.set(true)
    }
}
