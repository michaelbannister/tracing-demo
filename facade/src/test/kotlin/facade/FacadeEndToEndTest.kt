package facade

import com.natpryce.hamkrest.should.shouldMatch
import org.http4k.client.OkHttp
import org.http4k.core.ContentType.Companion.TEXT_PLAIN
import org.http4k.core.Method.GET
import org.http4k.core.Request
import org.http4k.core.Status.Companion.OK
import org.http4k.hamkrest.hasContentType
import org.http4k.hamkrest.hasStatus
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class FacadeEndToEndTest {
    private val client = OkHttp()
    private val server = Facade(0)

    @BeforeEach
    fun setup() {
        server.start()
    }

    @AfterEach
    fun teardown() {
        server.stop()
    }

    @Test
    fun `responds to a health check`() {
        client(Request(GET, "http://localhost:${server.port()}/healthz")) shouldMatch hasStatus(OK)
    }

    @Disabled("not implemented yet")
    @Test
    fun `responds to a product call`() {
        client(Request(GET, "http://localhost:${server.port()}/product-info/3")) shouldMatch hasContentType(TEXT_PLAIN)
    }
}