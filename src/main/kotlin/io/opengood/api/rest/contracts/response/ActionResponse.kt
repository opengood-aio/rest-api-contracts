package io.opengood.api.rest.contracts.response

data class ActionResponse(
    val state: OperationState,
    val message: String,
    val data: List<Map<String, Any>>,
)
