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
                "name" to "test",
                "filters" to mapOf("foo" to "bar"),
                "page" to mapOf(
                    "index" to 0,
                    "size" to 1
                ),
                "sort" to mapOf(
                    "params" to mapOf(
                        "foo" to "ASC"
                    )
                )
            )
        )
        bodyMatchers {
            jsonPath("$.name", byRegex("test"))
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
                        "id" to 1,
                        "foo" to "bar"
                    ),
                    mapOf(
                        "id" to 2,
                        "foo" to "baz"
                    )
                )
            )
        )
        bodyMatchers {
            jsonPath("$.message", byRegex("Data retrieved"))
        }
    }
}
