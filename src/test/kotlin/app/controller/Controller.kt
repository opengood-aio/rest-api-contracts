package app.controller

import io.opengood.api.rest.contracts.actionSuccessResponse
import io.opengood.api.rest.contracts.dataByIdSuccessResponse
import io.opengood.api.rest.contracts.dataSuccessResponse
import io.opengood.api.rest.contracts.page.PageData
import io.opengood.api.rest.contracts.page.PageState
import io.opengood.api.rest.contracts.record.RecordData
import io.opengood.api.rest.contracts.request.DeleteDataRequest
import io.opengood.api.rest.contracts.request.GetDataByIdRequest
import io.opengood.api.rest.contracts.request.GetDataRequest
import io.opengood.api.rest.contracts.request.SaveDataRequest
import io.opengood.api.rest.contracts.response.ActionResponse
import io.opengood.api.rest.contracts.response.DataByIdResponse
import io.opengood.api.rest.contracts.response.DataResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/data")
class Controller {

    @PostMapping("/delete")
    fun delete(@RequestBody request: DeleteDataRequest): ResponseEntity<ActionResponse> {
        return actionSuccessResponse(
            message = "Data deleted",
        )
    }

    @PostMapping("/get/id")
    fun getById(@RequestBody request: GetDataByIdRequest): ResponseEntity<DataByIdResponse> {
        return dataByIdSuccessResponse(
            message = "Data retrieved",
            data = mapOf(
                "product_id" to 1,
                "name" to "Product 1",
            ),
        )
    }

    @PostMapping("/get")
    fun get(@RequestBody request: GetDataRequest): ResponseEntity<DataResponse> {
        return dataSuccessResponse(
            message = "Data retrieved",
            pages = PageData(
                state = PageState.PAGINATED,
                index = 0,
                size = 2,
                count = 1,
            ),
            records = RecordData(
                total = 2,
            ),
            data = listOf(
                mapOf(
                    "product_id" to 1,
                    "name" to "Product 1",
                ),
                mapOf(
                    "product_id" to 2,
                    "name" to "Product 2",
                ),
            ),
        )
    }

    @PostMapping("/save")
    fun save(@RequestBody request: SaveDataRequest): ResponseEntity<ActionResponse> {
        return actionSuccessResponse(
            message = "Data saved",
            data = listOf(
                mapOf(
                    "product_id" to 1,
                    "name" to "Product 1",
                ),
            ),
        )
    }
}
