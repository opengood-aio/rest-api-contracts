package io.opengood.api.rest.contracts.filter

data class FilterParameter(
    val name: String,
    val value: Any,
    val type: FilterType
)
