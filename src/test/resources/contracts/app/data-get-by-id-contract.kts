import org.springframework.cloud.contract.spec.ContractDsl.Companion.contract

contract {
    name = "Get Data By ID"
    description = "Retrieves data"
    priority = 1
    ignored = false
    request {
        url = url("/data/get/id")
        method = POST
        headers {
            contentType = "application/json"
        }
        body = body(
            mapOf(
                "name" to "products",
                "id" to "82a94d9f-894c-4c00-ba40-a36e8f55f842",
            ),
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
                "state" to "SUCCESS",
                "message" to "Data retrieved",
                "data" to mapOf(
                    "product_id" to 1,
                    "name" to "Product 1",
                ),
            ),
        )
        bodyMatchers {
            jsonPath("$.message", byRegex("Data retrieved"))
        }
    }
}
