package landingPage.ktor.endpoints

import arrow.core.Either
import landingPage.ktor.Endpoint
import landingPage.ktor.Executor
import landingPage.ktor.HttpHeader
import landingPage.ktor.HttpMethod
import landingPage.ktor.HttpStatusCode
import landingPage.ktor.Request
import landingPage.ktor.ResponseFunction

public data class HtmlEndpoint<Error>(
    override val path: String,
    val block: suspend (Request) -> Either<Error, String>,
    val recover: suspend (Error, ResponseFunction<String>) -> Unit,
): Endpoint<Error, String> {
    override val httpMethod: HttpMethod = HttpMethod.Get
    override val header: Map<String, String> = mapOf(
        HttpHeader.ContentType.key to "text/html"
    )
    override val executor: Executor<Error, String> = Executor(
        block = block,
        response = { html, response ->
            response(HttpStatusCode.OK, html)
        },
        logicalRecover = recover,
        fatalRecover = { error, response ->
            response(HttpStatusCode.InternalServerError, error.message ?: "Unknown error")
        }
    )
}
