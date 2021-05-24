package spec

import app.Controller
import app.TestApplication
import org.junit.jupiter.api.BeforeEach
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup

@SpringBootTest(classes = [TestApplication::class])
abstract class AbstractBaseContractTest {

    @Autowired
    lateinit var controller: Controller

    @BeforeEach
    fun setup() {
        standaloneSetup(controller)
    }
}
