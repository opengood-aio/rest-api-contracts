package io.opengood.api.rest.contracts.page

enum class PageState(private val value: String) {
    NONE("None"),
    PAGINATED("Paginated"),
    ;

    override fun toString() = value
}
