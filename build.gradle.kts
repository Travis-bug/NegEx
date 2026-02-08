import com.vanniktech.maven.publish.SonatypeHost

        plugins {
            `java-library`
            signing
            id("com.vanniktech.maven.publish") version "0.30.0"
        }

group = "io.github.travis-bug"
version = "1.0.1"
description = "NegEx - A Java library for handling negative indexing"

mavenPublishing {
    // This single line handles the entire connection to the new Portal
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)

    //  Library Info
    coordinates("io.github.travis-bug", "negex", "1.0.1")

    pom {
        name.set("NegEx")
        description.set("A Java library for handling negative indexing")
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
                email.set("traviseweka39@gmail.com")
            }
        }
        scm {
            connection.set("scm:git:git://github.com/travis-bug/negex.git")
            developerConnection.set("scm:git:ssh://github.com/travis-bug/negex.git")
            url.set("https://github.com/travis-bug/negex")
        }

    }

    // Automatically signs using the key in my gradle.properties file
    signAllPublications()
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}


        dependencies {
            //  for terminal colors!
            api("org.fusesource.jansi:jansi:2.4.1")

            // Your testing libraries
            testImplementation("org.junit.jupiter:junit-jupiter:5.10.2")
            testRuntimeOnly("org.junit.platform:junit-platform-launcher")
        }


tasks.test {
    useJUnitPlatform()
}