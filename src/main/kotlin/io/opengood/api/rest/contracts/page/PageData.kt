package io.opengood.api.rest.contracts.page

data class PageData(
    val state: PageState,
    val index: Int,
    val size: Int,
    val count: Int,
) {
    companion object {
        val EMPTY =
            PageData(
                state = PageState.NONE,
                index = 0,
                size = 0,
                count = 0,
            )
    }
}
