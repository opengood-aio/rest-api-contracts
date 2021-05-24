package io.opengood.api.rest.contracts.response

import io.opengood.api.rest.contracts.page.PageData
import io.opengood.api.rest.contracts.record.RecordData

data class DataResponse(
    val state: OperationState,
    val message: String,
    val pages: PageData,
    val records: RecordData,
    val data: List<Map<String, Any>>
)
