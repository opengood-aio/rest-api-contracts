import io.opengood.gradle.enumeration.ProjectType
import org.springframework.cloud.contract.verifier.config.TestMode

plugins {
    id("io.opengood.gradle.config")
    id("org.springframework.cloud.contract")
}

group = "io.opengood.api"

opengood {
    main {
        projectType = ProjectType.LIB
    }
    test {
        frameworks {
            java = true
        }
    }
    artifact {
        description = "Reusable REST API contracts"
    }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web:_")

    testImplementation("org.springframework.cloud:spring-cloud-contract-spec-kotlin:_")
    testImplementation("org.springframework.cloud:spring-cloud-starter-contract-verifier:_")
}

contracts {
    testMode.set(TestMode.MOCKMVC)
    baseClassForTests.set("spec.AbstractBaseContractTest")
}
