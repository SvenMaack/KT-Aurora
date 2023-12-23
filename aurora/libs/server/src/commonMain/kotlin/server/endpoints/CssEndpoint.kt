package server.endpoints

import arrow.core.raise.either
import server.Endpoint
import server.Executor
import server.HttpHeader
import server.HttpMethod
import server.HttpStatusCode

public data class CssEndpoint(
    override val path: String,
    val css: String,
): Endpoint<Unit, String> {
    override val httpMethod: HttpMethod = HttpMethod.Get
    override val header: Map<String, String> = mapOf(
        HttpHeader.ContentType.key to "text/css"
    )
    override val executor: Executor<Unit, String> = Executor(
        block = {
            either { css }
        },
        response = { css->
            Pair(HttpStatusCode.OK, css)
        },
        logicalRecover = { _ ->
            Pair(HttpStatusCode.NotFound, "$path doesn't exist")
        },
        fatalRecover = { error ->
            Pair(HttpStatusCode.InternalServerError, error.message ?: "Unknown error")
        }
    )
}
