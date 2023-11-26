plugins {
  id("java")
  id("maven-publish")
}

group = "com.korbyte"
version = "0.4.2"

repositories {
  mavenCentral()
}


publishing {
  repositories {
    maven {
      name = "GitHubPackages"
      url = uri("https://maven.pkg.github.com/korbyte/alphavantage-java-client")
      credentials {
        username = project.findProperty("gpr.user") as String? ?: System.getenv("USERNAME")
        password = project.findProperty("gpr.key") as String? ?: System.getenv("TOKEN")
      }
    }
  }
  publications {
    register<MavenPublication>("gpr") {
      from(components["java"])
    }
  }
}

dependencies {
  annotationProcessor("org.projectlombok:lombok:1.18.26")

  implementation("org.projectlombok:lombok:1.18.26")
  implementation("com.squareup.okhttp3:okhttp:4.10.0")
  implementation("org.apache.httpcomponents.client5:httpclient5:5.2.1")

  implementation("com.fasterxml.jackson.core:jackson-core:2.15.2")
  implementation("com.fasterxml.jackson.core:jackson-databind:2.15.2")
  implementation("com.fasterxml.jackson.core:jackson-annotations:2.15.2")
  implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.15.2")
  implementation("com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.15.2")
  implementation("com.fasterxml.jackson.module:jackson-module-parameter-names:2.15.2")
  implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-csv:2.15.2")

  testImplementation(platform("org.junit:junit-bom:5.9.1"))
  testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
  useJUnitPlatform()
}
