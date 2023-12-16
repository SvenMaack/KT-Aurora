package landingPage.server.endpoints

import arrow.core.raise.either
import landingPage.server.Endpoint
import landingPage.server.Executor
import landingPage.server.HttpHeader
import landingPage.server.HttpMethod
import landingPage.server.HttpStatusCode

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
        response = { css, response ->
            response(HttpStatusCode.OK, css)
        },
        logicalRecover = { _, response ->
            response(HttpStatusCode.NotFound, "$path doesn't exist")
        },
        fatalRecover = { error, response ->
            response(HttpStatusCode.InternalServerError, error.message ?: "Unknown error")
        }
    )
}
