package server.servers

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.cio.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.util.*
import me.tatarka.inject.annotations.Inject
import server.Endpoint
import server.Request
import server.Server

@Inject
public class KtorServer(
    port: Int = 8080
): Server {
    private val server = embeddedServer(CIO, configure = {
        connectionIdleTimeoutSeconds = 30
    }, port = port) {
    }

    public override fun <Error, Data>initEndpoint(endpoint: Endpoint<Error, Data>): KtorServer {
        server.application.routing {
            route(endpoint.path, HttpMethod.parse(endpoint.httpMethod.method)) {
                handle {
                    endpoint.header.forEach {(key, value) ->
                        call.response.header(key, value)
                    }
                    val (code, result) = ServerHandler<Error, Data>()
                        .handle(endpoint, buildRequest(call))
                    call.respond(
                        HttpStatusCode.fromValue(code.code),
                        result
                    )
                }
            }
        }
        return this
    }

    private fun buildRequest(call: ApplicationCall): Request {
        return Request(
            queryParameters = call.request.queryParameters.toMap()
                .filter {
                    it.value.isNotEmpty()
                }
                .mapValues {
                    it.value.last()
                },
            path = call.request.path()
        )
    }

    public override fun start() {
        server.start(true)
    }
}
