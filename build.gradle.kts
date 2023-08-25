plugins {
  id("java")
  id("maven-publish")
}

group = "com.korbyte"
version = "0.3.8"

repositories {
  mavenCentral()
}


publishing {
  repositories {
    maven {
      name = "GitHubPackages"
      url = uri("https://maven.pkg.github.com/korbyte/alphavantage-client-java")
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

  implementation("com.fasterxml.jackson.core:jackson-databind:2.15.2")
  implementation("com.opencsv:opencsv:5.8")

  testImplementation(platform("org.junit:junit-bom:5.9.1"))
  testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
  useJUnitPlatform()
}
