package landingPage.ktor.endpoints

import arrow.core.raise.either
import landingPage.ktor.Endpoint
import landingPage.ktor.Executor
import landingPage.ktor.HttpHeader
import landingPage.ktor.HttpMethod
import landingPage.ktor.HttpStatusCode

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
