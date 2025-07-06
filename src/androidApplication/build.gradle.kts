// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    id "org.sonarqube" version "6.2.0.5505"
}

sonar {
  properties {
    property "sonar.projectKey", "SW-Engineering-Courses-Karina-Kohl_tcp-final-20251-grupo01"
    property "sonar.organization", "sw-engineering-courses-karina-kohl"
    property "sonar.host.url", "https://sonarcloud.io"
  }
}
