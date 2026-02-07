plugins {
    `java-library`
    `maven-publish`
    signing
}

// These identify your library on Maven Central
group = "io.github.travis-bug"
version = "1.0.1"
description = "NegEx - A Java library for handling negative indexing"

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8

    // Maven Central requires these extra JARs
    withSourcesJar()
    withJavadocJar()
}

repositories {
    mavenCentral()
}

dependencies {
    // Keeping your terminal color support
    api("org.fusesource.jansi:jansi:2.4.1")

    // Modern JUnit 5 for your tests
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.2")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])

            pom {
                name.set("NegEx")
                description.set(project.description)
                url.set("https://github.com/travis-bug/negex")

                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }

                developers {
                    developer {
                        id.set("travis-bug")
                        name.set("Travis Eweka")
                        email.set("your-email@example.com") // Recommended to add
                    }
                }

                scm {
                    connection.set("scm:git:git://github.com/travis-bug/negex.git")
                    developerConnection.set("scm:git:ssh://github.com/travis-bug/negex.git")
                    url.set("https://github.com/travis-bug/negex")
                }
            }
        }
    }

    // This tells Gradle where to send the files
    repositories {
        maven {
            name = "OSSRH"
            url = uri("https://central.sonatype.com/api/v1/publisher/upload")
            credentials {
                username = project.property("mavenCentralUsername").toString()
                password = project.property("mavenCentralPassword").toString()
            }
        }
    }
}

signing {
    // This signs the artifacts using the GPG key from your gradle.properties
    sign(publishing.publications["mavenJava"])
}

tasks.test {
    useJUnitPlatform()
}