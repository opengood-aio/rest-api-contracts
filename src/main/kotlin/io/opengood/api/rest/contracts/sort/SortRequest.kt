package io.opengood.api.rest.contracts.sort

data class SortRequest(
    val params: List<SortParameter>,
) {
    companion object {
        val EMPTY =
            SortRequest(
                params = emptyList(),
            )
    }
}
