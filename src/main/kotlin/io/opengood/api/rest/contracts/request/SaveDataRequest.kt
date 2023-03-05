package io.opengood.api.rest.contracts.request

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonInclude.Include

data class SaveDataRequest(
    @JsonInclude(Include.NON_EMPTY)
    val name: String,
    @JsonInclude(Include.NON_EMPTY)
    val data: List<Map<String, Any>>,
)
