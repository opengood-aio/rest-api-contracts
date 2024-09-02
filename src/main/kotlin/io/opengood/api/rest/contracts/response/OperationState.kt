package io.opengood.api.rest.contracts.response

enum class OperationState(
    private val value: String,
) {
    SUCCESS("Success"),
    FAILED("Failed"),
    ;

    override fun toString() = value
}
