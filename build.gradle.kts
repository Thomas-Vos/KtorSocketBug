plugins {
    kotlin("multiplatform") version "1.4.31"
}

group = "me.paul"
version = "1.0"

repositories {
    jcenter()
    mavenCentral()
}

kotlin {
    iosArm64 {
        binaries {
            framework {
                baseName = "library"
                linkerOpts.add("-lsqlite3")
            }
        }
    }
    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val iosArm64Main by getting {
            dependencies {
                val version = "1.5.2"
                implementation("io.ktor:ktor-network:$version")
                implementation("io.ktor:ktor-client-ios:$version")
            }
        }
        val iosArm64Test by getting
    }
}
