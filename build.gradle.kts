import io.opengood.gradle.enumeration.ProjectType
import org.springframework.cloud.contract.verifier.config.TestMode

plugins {
    id("io.opengood.gradle.config") version "1.22.0"
    id("org.springframework.cloud.contract") version "3.0.3"
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
    const val SPRING_CLOUD_CONTRACT = "3.0.3"
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")

    testImplementation("org.springframework.cloud:spring-cloud-contract-spec-kotlin:${Versions.SPRING_CLOUD_CONTRACT}")
    testImplementation("org.springframework.cloud:spring-cloud-starter-contract-verifier:${Versions.SPRING_CLOUD_CONTRACT}")
}

contracts {
    testMode.set(TestMode.MOCKMVC)
    baseClassForTests.set("spec.AbstractBaseContractTest")
}
