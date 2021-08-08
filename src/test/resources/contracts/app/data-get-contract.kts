import org.springframework.cloud.contract.spec.ContractDsl.Companion.contract

contract {
    name = "Get Data"
    description = "Retrieves data"
    priority = 1
    ignored = false
    request {
        url = url("/data/get")
        method = POST
        headers {
            contentType = "application/json"
        }
        body = body(
            mapOf(
                "name" to "products",
                "filters" to mapOf(
                    "name" to "Product 1"
                ),
                "page" to mapOf(
                    "index" to 0,
                    "size" to 1
                ),
                "sort" to mapOf(
                    "params" to mapOf(
                        "product_name" to "ASC"
                    )
                )
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
                "state" to "SUCCESS",
                "message" to "Data retrieved",
                "pages" to mapOf(
                    "state" to "PAGINATED",
                    "index" to 0,
                    "size" to 2,
                    "count" to 1
                ),
                "records" to mapOf(
                    "total" to 2
                ),
                "data" to listOf(
                    mapOf(
                        "product_id" to 1,
                        "name" to "Product 1"
                    ),
                    mapOf(
                        "product_id" to 2,
                        "name" to "Product 2"
                    )
                )
            )
        )
        bodyMatchers {
            jsonPath("$.message", byRegex("Data retrieved"))
        }
    }
}
