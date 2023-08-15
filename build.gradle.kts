plugins {
    id("java")
    id("maven-publish")
}

group = "com.korbyte"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}


publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/korbyte/alphavantage-client-java")
            credentials {
                username = System.getenv("GITHUB_ACTOR")
                password = System.getenv("GITHUB_TOKEN")
            }
        }
    }
}

dependencies {
    annotationProcessor("org.projectlombok:lombok:1.18.26")

    implementation("org.projectlombok:lombok:1.18.26")
    implementation("com.squareup.okhttp3:okhttp:4.10.0")
    implementation ("org.apache.httpcomponents:httpclient:4.5.13")
    implementation ("com.fasterxml.jackson.core:jackson-databind:2.15.2")

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}