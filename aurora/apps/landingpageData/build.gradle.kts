import io.gitlab.arturbosch.detekt.Detekt

plugins {
    kotlin("jvm") version "1.9.10"
    id("com.google.devtools.ksp") version "1.9.10-1.0.13"
    id("io.gitlab.arturbosch.detekt") version "1.23.4"
    application
}

group = "maack.aurora"
version = "1.0.0"

repositories {
    gradlePluginPortal()
    mavenCentral()
}

dependencies {
    implementation("com.datastax.cassandra:cassandra-driver-core:4.0.0")
    implementation("com.datastax.oss:java-driver-query-builder:4.17.0")

    implementation("io.ktor:ktor-server-core:2.3.5")
    implementation("io.ktor:ktor-server-cio:2.3.5")

    implementation("io.arrow-kt:arrow-core:1.2.1")
    implementation("io.arrow-kt:arrow-fx-coroutines:1.2.1")
    detektPlugins("com.wolt.arrow.detekt:rules:0.4.0")

    ksp("me.tatarka.inject:kotlin-inject-compiler-ksp:0.6.3")
    implementation("me.tatarka.inject:kotlin-inject-runtime:0.6.3")

    testImplementation(kotlin("test"))
    testImplementation("io.mockative:mockative:2.0.0")

    implementation("org.apache.logging.log4j:log4j-slf4j-impl:2.1")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    explicitApi()
    jvmToolchain(8)
}

application {
    mainClass.set("landingpagedata.MainKt")
}

detekt {
    source.setFrom("src/main/kotlin")
    allRules = true
    config.setFrom("$projectDir/config/detekt.yml")
    parallel = true
}
tasks.withType<Detekt>().configureEach {
    reports {
        html.required.set(true)
    }
}

