import io.opengood.gradle.enumeration.ProjectType

plugins {
    id("io.opengood.gradle.config") version "1.22.0"
    id("org.springframework.cloud.contract") version "3.0.2"
}

group = "io.opengood.api"

opengood {
    main {
        projectType = ProjectType.LIB
    }
    test {
        testFrameworks {
            java = true
        }
    }
    artifact {
        description = "Reusable REST API contracts"
    }
}

object Versions {
    const val SPRING_CLOUD_CONTRACT = "3.0.3-SNAPSHOT"
}

repositories {
    maven { url = uri("https://repo.spring.io/snapshot") }
    maven { url = uri("https://repo.spring.io/milestone") }
    maven { url = uri("https://repo.spring.io/release") }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")

    testImplementation("org.springframework.cloud:spring-cloud-contract-spec-kotlin:${Versions.SPRING_CLOUD_CONTRACT}")
}

contracts {
    baseClassForTests.set("spec.AbstractBaseContractTest")
}
