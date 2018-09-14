package facade

import org.http4k.core.Method
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status.Companion.OK
import org.http4k.routing.bind
import org.http4k.routing.routes
import org.http4k.server.Http4kServer
import org.http4k.server.Jetty
import org.http4k.server.asServer

fun main(args: Array<String>) {
    val app = routes(
        "/healthz" bind Method.GET to {
            Response(OK).body("OK")
        }
    )
}

fun Facade(port: Int): Http4kServer = { _: Request -> Response(OK) }.asServer(Jetty(port))