plugins {
    java
    application
    id("org.openjfx.javafxplugin").version("0.0.8")
}

java {
    sourceCompatibility = JavaVersion.VERSION_13
}

    group = "org.example"
    version = "1.0-SNAPSHOT"

javafx {
    version = "13"
    modules = listOf("javafx.controls", "javafx.fxml")
}

application {
    mainClassName = "sample.Main"
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("junit:junit:4.12")
    implementation("de.saxsys:mvvmfx:1.8.0")
}
