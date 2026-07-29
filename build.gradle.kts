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
//
//tasks.register("simpleTask"){
//    group = "build"
//    println("Simple test runing")
//}
//tasks.named ("simpleTask"){
//    dependsOn("clean")
//}
//tasks.register<Test>("smoke") {
//    group = "tests "
//    systemProperty("CIRCUIT", System.getProperty("circuit", "DEV"))
//    useJUnitPlatform {
//        includeTags("Smoke")
//    }


//home work Тема 2. Gradle и JUnit
//Задача запускает все тесты в проекте.
    tasks.register<Test>("startAllMethods") {
        group = "DZ"
        useJUnitPlatform(){
            includeTags("DZ1")
        }
        doLast {
            println("Test run is over")
        }
    }



tasks.named("startAllMethods"){
}



