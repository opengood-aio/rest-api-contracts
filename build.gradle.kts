import org.springframework.cloud.contract.verifier.config.TestMode

plugins {
    id("io.opengood.gradle.config")
    id("org.springframework.cloud.contract")
}

group = "io.opengood.api"

opengood {
    features {
        assertj = true
        junitJupiter = true
        lombok = true
    }
    artifact {
        description = "Reusable REST API contracts"
    }
}

configurations.all {
    resolutionStrategy.eachDependency {
        if (requested.group == "org.jetbrains.kotlin" && requested.name == "kotlin-script-util") {
            useVersion("1.8.22")
            because("Incompatibilities with older Kotlin versions")
        }
    }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")

    testImplementation("org.springframework.cloud:spring-cloud-contract-spec-kotlin:_")
    testImplementation("org.springframework.cloud:spring-cloud-starter-contract-verifier:_")
}

contracts {
    testMode.set(TestMode.MOCKMVC)
    baseClassForTests.set("test.spec.AbstractBaseContractTest")
}
