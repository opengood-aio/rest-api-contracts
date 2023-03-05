package io.opengood.api.rest.contracts.response

data class DataByIdResponse(
    val state: OperationState,
    val message: String,
    val data: Map<String, Any>,
)
