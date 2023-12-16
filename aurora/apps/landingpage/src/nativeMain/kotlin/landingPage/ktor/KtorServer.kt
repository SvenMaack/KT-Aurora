package landingPage.ktor

import arrow.core.raise.fold
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.cio.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

public class KtorServer(port: Int = 8080): Server {
    private val server = embeddedServer(CIO, configure = {
        connectionIdleTimeoutSeconds = 30
    }, port = port) {}

    public override fun <Error, Data>initEndpoint(endpoint: Endpoint<Error, Data>): KtorServer {
        server.application.routing {
            route(endpoint.path, endpoint.httpMethod) {
                handle {
                    endpoint.header.forEach {(key, value) ->
                        call.response.header(key, value)
                    }
                    fold(
                        block = {
                            endpoint.executor.block(call).bind()
                        },
                        recover = { e: Error ->
                            endpoint.executor.recover(call, e)
                        },
                        transform = { data: Data ->
                            endpoint.executor.response(call, data)
                        }
                    )
                }
            }
        }
        return this
    }

    public override fun start() {
        server.start(true)
    }
}