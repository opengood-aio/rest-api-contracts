package io.opengood.api.rest.contracts

import io.opengood.api.rest.contracts.page.PageData
import io.opengood.api.rest.contracts.record.RecordData
import io.opengood.api.rest.contracts.response.ActionResponse
import io.opengood.api.rest.contracts.response.DataByIdResponse
import io.opengood.api.rest.contracts.response.DataResponse
import io.opengood.api.rest.contracts.response.OperationState
import org.springframework.http.ResponseEntity

fun actionFailedResponse(
    message: String
) =
    ResponseEntity.badRequest().body(
        ActionResponse(
            state = OperationState.FAILED,
            message = message,
            data = emptyList()
        )
    )

fun actionSuccessResponse(
    message: String = "",
    data: List<Map<String, Any>> = emptyList()
) =
    ResponseEntity.ok(
        ActionResponse(
            state = OperationState.SUCCESS,
            message = message,
            data = data
        )
    )

fun dataByIdFailedResponse(
    message: String
) =
    ResponseEntity.badRequest().body(
        DataByIdResponse(
            state = OperationState.FAILED,
            message = message,
            data = emptyMap()
        )
    )

fun dataByIdSuccessResponse(
    message: String = "",
    data: Map<String, Any>
) =
    ResponseEntity.ok(
        DataByIdResponse(
            state = OperationState.SUCCESS,
            message = message,
            data = data
        )
    )

fun dataFailedResponse(
    message: String
) =
    ResponseEntity.badRequest().body(
        DataResponse(
            state = OperationState.FAILED,
            message = message,
            pages = PageData.EMPTY,
            records = RecordData.EMPTY,
            data = emptyList()
        )
    )

fun dataSuccessResponse(
    message: String = "",
    pages: PageData = PageData.EMPTY,
    records: RecordData = RecordData.EMPTY,
    data: List<Map<String, Any>>
) =
    ResponseEntity.ok(
        DataResponse(
            state = OperationState.SUCCESS,
            message = message,
            pages = pages,
            records = records,
            data = data
        )
    )
