package io.opengood.api.rest.contracts.request

import com.fasterxml.jackson.annotation.JsonInclude
import io.opengood.api.rest.contracts.page.PageRequest
import io.opengood.api.rest.contracts.sort.SortRequest

data class GetDataRequest(
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    val name: String,
    val filters: Map<String, Any> = emptyMap(),
    val page: PageRequest = PageRequest.EMPTY,
    val sort: SortRequest = SortRequest.EMPTY
)
