package landingPage.ktor

import arrow.core.Either
import arrow.core.raise.either
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*

public data class Executor<Error, Data>(
    val block: suspend (ApplicationCall) -> Either<Error, Data>,
    val recover: suspend (ApplicationCall, Error) -> Unit,
    val response: suspend (ApplicationCall, Data) -> Unit
)

public interface Endpoint<Error, Data> {
    public val path: String
    public val httpMethod: HttpMethod
    public val header: Map<String, String>
    public val executor: Executor<Error, Data>
}

public data class HtmlEndpoint<Error>(
    override val path: String,
    val block: suspend (ApplicationCall) -> Either<Error, String>,
    val recover: suspend (ApplicationCall, Error) -> Unit,
): Endpoint<Error, String> {
    override val httpMethod: HttpMethod = HttpMethod.Get
    override val header: Map<String, String> = mapOf(
        HttpHeaders.ContentType to "text/html"
    )
    override val executor: Executor<Error, String> = Executor(
        block = block,
        recover = recover,
        response = { call, html ->
            call.respondText(html)
        }
    )
}

public data class CssEndpoint(
    override val path: String,
    val css: String,
): Endpoint<Unit, String> {
    override val httpMethod: HttpMethod = HttpMethod.Get
    override val header: Map<String, String> = mapOf(
        HttpHeaders.ContentType to "text/css"
    )
    override val executor: Executor<Unit, String> = Executor(
        block = {
            either { css }
        },
        recover = { call, _->
            call.respond(HttpStatusCode.NotFound, "$path doesn't exist")
        },
        response = { call, html ->
            call.respondText(html)
        }
    )
}
