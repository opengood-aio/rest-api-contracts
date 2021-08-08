import org.springframework.cloud.contract.spec.ContractDsl.Companion.contract

contract {
    name = "Delete Data"
    description = "Deletes data"
    priority = 1
    ignored = false
    request {
        url = url("/data/delete")
        method = POST
        headers {
            contentType = "application/json"
        }
        body = body(
            mapOf(
                "name" to "products",
                "id" to "82a94d9f-894c-4c00-ba40-a36e8f55f842"
            )
        )
        bodyMatchers {
            jsonPath("$.name", byRegex("products"))
        }
    }
    response {
        status = OK
        headers {
            contentType = "application/json"
        }
        body = body(
            mapOf(
                "message" to "Data deleted"
            )
        )
        bodyMatchers {
            jsonPath("$.message", byRegex("Data deleted"))
        }
    }
}
