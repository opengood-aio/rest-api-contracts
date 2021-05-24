package app

import io.opengood.api.rest.contracts.actionSuccessResponse
import io.opengood.api.rest.contracts.request.SaveDataRequest
import io.opengood.api.rest.contracts.response.ActionResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/data")
class Controller {

    @PostMapping("/save")
    fun save(@RequestBody request: SaveDataRequest): ResponseEntity<ActionResponse> {
        return actionSuccessResponse(
            message = "Data saved",
            data = listOf(mapOf("foo" to "bar"))
        )
    }
}
