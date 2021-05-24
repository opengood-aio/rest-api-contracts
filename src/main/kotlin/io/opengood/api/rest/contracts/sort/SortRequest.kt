package io.opengood.api.rest.contracts.sort

data class SortRequest(
    val params: Map<String, SortDirection>
) {
    companion object {
        val EMPTY = SortRequest(
            params = emptyMap()
        )
    }
}
