package app.test.spec

import app.TestApplication
import app.controller.Controller
import io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup
import org.junit.jupiter.api.BeforeEach
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(classes = [TestApplication::class])
abstract class AbstractBaseContractTest {

    @Autowired
    lateinit var controller: Controller

    @BeforeEach
    fun setup() {
        standaloneSetup(controller)
    }
}
