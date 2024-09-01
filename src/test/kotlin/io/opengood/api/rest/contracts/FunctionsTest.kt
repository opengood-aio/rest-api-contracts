package io.opengood.api.rest.contracts

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.opengood.api.rest.contracts.page.PageData
import io.opengood.api.rest.contracts.record.RecordData
import io.opengood.api.rest.contracts.response.ActionResponse
import io.opengood.api.rest.contracts.response.DataByIdResponse
import io.opengood.api.rest.contracts.response.DataResponse
import io.opengood.api.rest.contracts.response.OperationState
import org.springframework.http.HttpStatus

class FunctionsTest :
    FunSpec({

        test(
            "actionFailedResponse function returns response entity with bad request status, failed state, message, and empty list of data",
        ) {
            val response = actionFailedResponse(message = "Error")

            with(response) {
                statusCode shouldBe HttpStatus.BAD_REQUEST
                body shouldBe
                    ActionResponse(
                        state = OperationState.FAILED,
                        message = "Error",
                        data = emptyList(),
                    )
            }
        }

        test("actionSuccessResponse function returns response entity with ok status, success state, no message, and empty list of data") {
            val response = actionSuccessResponse()

            with(response) {
                statusCode shouldBe HttpStatus.OK
                body shouldBe
                    ActionResponse(
                        state = OperationState.SUCCESS,
                        message = "",
                        data = emptyList(),
                    )
            }
        }

        test(
            "dataByIdFailedResponse function returns response entity with bad request status, failed state, message, and empty map of data",
        ) {
            val response = dataByIdFailedResponse(message = "Error")

            with(response) {
                statusCode shouldBe HttpStatus.BAD_REQUEST
                body shouldBe
                    DataByIdResponse(
                        state = OperationState.FAILED,
                        message = "Error",
                        data = emptyMap(),
                    )
            }
        }

        test("dataByIdSuccessResponse function returns response entity with ok status, success state, no message, and map of data") {
            val data =
                mapOf(
                    "product_id" to 1,
                    "name" to "Product 1",
                )

            val response = dataByIdSuccessResponse(data = data)

            with(response) {
                statusCode shouldBe HttpStatus.OK
                body shouldBe
                    DataByIdResponse(
                        state = OperationState.SUCCESS,
                        message = "",
                        data = data,
                    )
            }
        }

        test(
            "dataFailedResponse function returns response entity with bad request status, failed state, message, empty pages, empty records, and empty list of data",
        ) {
            val response = dataFailedResponse(message = "Error")

            with(response) {
                statusCode shouldBe HttpStatus.BAD_REQUEST
                body shouldBe
                    DataResponse(
                        state = OperationState.FAILED,
                        message = "Error",
                        pages = PageData.EMPTY,
                        records = RecordData.EMPTY,
                        data = emptyList(),
                    )
            }
        }

        test(
            "dataSuccessResponse function returns response entity with ok status, success state, no message, empty pages, empty records, and list of data",
        ) {
            val data =
                listOf(
                    mapOf(
                        "product_id" to 1,
                        "name" to "Product 1",
                    ),
                )

            val response = dataSuccessResponse(data = data)

            with(response) {
                statusCode shouldBe HttpStatus.OK
                body shouldBe
                    DataResponse(
                        state = OperationState.SUCCESS,
                        message = "",
                        pages = PageData.EMPTY,
                        records = RecordData.EMPTY,
                        data = data,
                    )
            }
        }
    })
