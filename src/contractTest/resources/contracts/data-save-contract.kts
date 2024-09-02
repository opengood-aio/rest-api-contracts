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
        body =
            body(
                mapOf(
                    "name" to "products",
                    "data" to
                        listOf(
                            mapOf(
                                "name" to "Product 1",
                            ),
                        ),
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
        body =
            body(
                mapOf(
                    "message" to "Data saved",
                    "data" to
                        listOf(
                            mapOf(
                                "product_id" to 1,
                                "name" to "Product 1",
                            ),
                        ),
                ),
            )
        bodyMatchers {
            jsonPath("$.message", byRegex("Data saved"))
        }
    }
}
