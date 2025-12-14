plugins {
    java
    application
}

group = "com.matrixCalculator"

repositories {
    mavenCentral()
}

tasks.test {
    useJUnitPlatform()
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

application {
    mainClass.set("com.matrixCalculator.Main")
}

tasks.run.get().apply {
    standardInput = System.`in`
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "com.matrixCalculator.Main"
        attributes["Module-Main-Class"] = "com.matrixCalculator"
    }
}

tasks.javadoc {
    source = sourceSets.main.get().java
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.javadoc {
    options.encoding = "UTF-8"
}

tasks.withType<JavaExec> {
    jvmArgs = listOf("-Dfile.encoding=CP866")
}