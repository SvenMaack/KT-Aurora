plugins {
    kotlin("jvm") version "1.9.0"
    id("com.squareup.wire") version "4.9.3"
    application
}

group = "maack.aurora"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("com.datastax.cassandra:cassandra-driver-core:4.0.0")
    implementation("com.datastax.oss:java-driver-query-builder:4.17.0")

    implementation("com.squareup.wire:wire-runtime:4.9.3")
    implementation("com.squareup.wire:wire-grpc-server:4.9.3")
    implementation("io.grpc:grpc-kotlin-stub:1.4.1")
    implementation("io.grpc:grpc-protobuf:1.60.0")
    implementation("io.grpc:grpc-netty:1.60.0")

}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}

application {
    mainClass.set("MainKt")
}

wire {
    sourcePath {
        srcDir("src/main/proto/example")
    }

    kotlin {
        rpcCallStyle = "suspending"
        rpcRole = "server"
        grpcServerCompatible = true
        singleMethodServices = true
    }
}
