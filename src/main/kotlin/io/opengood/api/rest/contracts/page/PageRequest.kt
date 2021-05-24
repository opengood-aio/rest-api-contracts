package io.opengood.api.rest.contracts.page

data class PageRequest(
    val index: Int,
    val size: Int
) {
    companion object {
        val EMPTY = PageRequest(
            index = 0,
            size = 0
        )
    }
}
