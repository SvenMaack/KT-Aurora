package landingPage.ktor.servers

import arrow.core.Either
import arrow.core.raise.fold
import io.ktor.http.HttpMethod
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.cio.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.util.*
import landingPage.ktor.Endpoint
import landingPage.ktor.Request
import landingPage.ktor.Server

public class KtorServer(port: Int = 8080): Server {
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
                    fold(
                        block = {
                            block(endpoint, call).bind()
                        },
                        recover = { error: Error ->
                            recover(endpoint, error, call)
                        },
                        transform = { data: Data ->
                            transform(endpoint, data, call)
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

    private suspend fun <Error, Data>block(
        endpoint: Endpoint<Error, Data>,
        call: ApplicationCall
    ): Either<Error, Data> {
        val request = Request(
            queryParameters = call.request.queryParameters.toMap()
                .filter {
                    it.value.isNotEmpty()
                }
                .mapValues {
                    it.value.last()
                },
            uri = call.request.uri
        )
        return endpoint.executor.block(request)
    }

    private suspend fun <Error, Data>recover(
        endpoint: Endpoint<Error, Data>,
        error: Error,
        call: ApplicationCall
    ) {
        endpoint.executor.recover(error) { httpCode, errorAsString ->
            call.respond(io.ktor.http.HttpStatusCode.fromValue(httpCode.code), errorAsString)
        }
    }

    private suspend fun <Error, Data>transform(
        endpoint: Endpoint<Error, Data>,
        data: Data,
        call: ApplicationCall
    ) {
        endpoint.executor.response(data) { httpCode, resultData->
            call.respond(io.ktor.http.HttpStatusCode.fromValue(httpCode.code), resultData)
        }
    }
}