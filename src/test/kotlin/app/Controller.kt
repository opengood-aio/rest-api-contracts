package app

import io.opengood.api.rest.contracts.actionSuccessResponse
import io.opengood.api.rest.contracts.dataSuccessResponse
import io.opengood.api.rest.contracts.page.PageData
import io.opengood.api.rest.contracts.page.PageState
import io.opengood.api.rest.contracts.record.RecordData
import io.opengood.api.rest.contracts.request.GetDataRequest
import io.opengood.api.rest.contracts.request.SaveDataRequest
import io.opengood.api.rest.contracts.response.ActionResponse
import io.opengood.api.rest.contracts.response.DataResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/data")
class Controller {

    @PostMapping("/get")
    fun get(@RequestBody request: GetDataRequest): ResponseEntity<DataResponse> {
        return dataSuccessResponse(
            message = "Data retrieved",
            pages = PageData(
                state = PageState.PAGINATED,
                index = 0,
                size = 2,
                count = 1
            ),
            records = RecordData(
                total = 2
            ),
            data = listOf(
                mapOf(
                    "id" to 1,
                    "foo" to "bar"
                ),
                mapOf(
                    "id" to 2,
                    "foo" to "baz"
                )
            )
        )
    }

    @PostMapping("/save")
    fun save(@RequestBody request: SaveDataRequest): ResponseEntity<ActionResponse> {
        return actionSuccessResponse(
            message = "Data saved",
            data = listOf(mapOf("foo" to "bar"))
        )
    }
}
