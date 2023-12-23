package server.endpoints

import arrow.core.Either
import server.Endpoint
import server.Executor
import server.HttpHeader
import server.HttpMethod
import server.HttpStatusCode
import server.Request

public data class HtmlEndpoint<Error>(
    override val path: String,
    val block: suspend (Request) -> Either<Error, String>,
    val recover: suspend (Error) -> Pair<HttpStatusCode, String>,
): Endpoint<Error, String> {
    override val httpMethod: HttpMethod = HttpMethod.Get
    override val header: Map<String, String> = mapOf(
        HttpHeader.ContentType.key to "text/html"
    )
    override val executor: Executor<Error, String> = Executor(
        block = block,
        response = { html ->
            Pair(HttpStatusCode.OK, html)
        },
        logicalRecover = recover,
        fatalRecover = { error ->
            Pair(HttpStatusCode.InternalServerError, error.message ?: "Unknown error")
        }
    )
}
