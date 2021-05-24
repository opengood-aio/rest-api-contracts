import org.springframework.cloud.contract.spec.ContractDsl.Companion.contract

contract {
    name = "Save Data"
    description = "Saves data"
    priority = 1
    ignored = false
    request {
        url = url("/data/save")
        method = POST
        headers {
            contentType = "application/json"
        }
        body = body(
            mapOf(
                "name" to "test",
                "data" to listOf(mapOf("foo" to "bar"))
            )
        )
        bodyMatchers {
            jsonPath("$.name", byRegex("test"))
        }
    }
    response {
        delay = fixedMilliseconds(1000)
        status = OK
        headers {
            contentType = "application/json"
        }
        body = body(
            mapOf(
                "message" to "Data saved",
                "data" to listOf(mapOf("foo" to "bar"))
            )
        )
        bodyMatchers {
            jsonPath("$.message", byRegex("Data saved"))
        }
    }
}
