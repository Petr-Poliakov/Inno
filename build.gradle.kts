plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.rest-assured:rest-assured:5.5.6")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testImplementation ("org.junit.jupiter:junit-jupiter-params:5.10.0")
    // Source: https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-core
    implementation("com.fasterxml.jackson.core:jackson-core:2.20.1")
    // Source: https://mvnrepository.com/artifact/org.assertj/assertj-core
    implementation("org.assertj:assertj-core:3.27.7")
    testImplementation("org.seleniumhq.selenium:selenium-java:4.43.0")
    testImplementation("com.codeborne:selenide:7.16.0")
// Source: https://mvnrepository.com/artifact/com.codeborne/selenide
    implementation("com.codeborne:selenide:7.18.1")
    testImplementation("org.assertj:assertj-core:3.27.7")
    // Source: https://mvnrepository.com/artifact/org.projectlombok/lombok
    implementation("org.projectlombok:lombok:1.18.46")
}

val tagsFilter: String? = findProperty("tags") as String?

tasks.test {
    useJUnitPlatform {
        if (tagsFilter != null) {
            includeTags(tagsFilter)
        }
    }
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



