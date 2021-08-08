package io.opengood.api.rest.contracts.request

import com.fasterxml.jackson.annotation.JsonInclude

data class GetDataByIdRequest(
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    val name: String,
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    val id: String
)
