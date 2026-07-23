plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    // Source: https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-core
    implementation("com.fasterxml.jackson.core:jackson-core:2.20.1")
}

tasks.test {
    useJUnitPlatform()
}

tasks.register("simpleTask"){
    group = "build"
    println("Simple test runing")
}
tasks.named ("simpleTask"){
    dependsOn("clean")
}
tasks.register<Test>("smoke"){
    group = "tests "
    systemProperty("CIRCUIT", System.getProperty("circuit", "DEV"))
    useJUnitPlatform{
        includeTags("Smoke")
    }

}

tasks.register("starMethod"){
/*    doLast {
        println("Test method end")
        println("===================================================")
    }*/
    println("===================================================")
    println("Test method start")
}

tasks.register("endMethod"){
    println("Test method end")
    println("===================================================")
}