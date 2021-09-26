package io.opengood.api.rest.contracts.filter

data class FilterRequest(
    val params: List<FilterParameter>
) {
    companion object {
        val EMPTY = FilterRequest(
            params = emptyList()
        )
    }
}
