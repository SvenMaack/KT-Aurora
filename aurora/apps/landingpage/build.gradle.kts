import io.gitlab.arturbosch.detekt.Detekt

plugins {
    kotlin("multiplatform") version "1.9.10"
    id("com.google.devtools.ksp") version "1.9.10-1.0.13"
    id("io.gitlab.arturbosch.detekt") version "1.23.4"
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

    nativeTarget.apply {
        binaries {
            executable {
                entryPoint = "main"
            }
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("maack.aurora:page:1.0.0")
                implementation("maack.aurora:navigation:1.0.0")
                implementation("maack.aurora:head:1.0.0")
                implementation("maack.aurora:basic:1.0.0")

                implementation("io.ktor:ktor-server-core:2.3.5")
                implementation("io.ktor:ktor-server-cio:2.3.5")

                implementation("io.arrow-kt:arrow-core:1.2.1")
                implementation("io.arrow-kt:arrow-fx-coroutines:1.2.1")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation("io.mockative:mockative:2.0.0")
            }
        }
        val nativeMain by getting
        val nativeTest by getting
    }
}

dependencies {
    configurations
        .filter { it.name.startsWith("ksp") && it.name.contains("Test") }
        .forEach {
            add(it.name, "io.mockative:mockative-processor:2.0.0")
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

