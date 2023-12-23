package server

import arrow.core.Either

public data class Executor<Error, Data>(
    val block: suspend (Request) -> Either<Error, Data>,
    val logicalRecover: suspend (Error) -> Pair<HttpStatusCode, String>,
    val fatalRecover: suspend (Throwable) -> Pair<HttpStatusCode, String>,
    val response: suspend (Data) -> Pair<HttpStatusCode, String>
)

public interface Endpoint<Error, Data> {
    public val path: String
    public val httpMethod: HttpMethod
    public val header: Map<String, String>
    public val executor: Executor<Error, Data>
}
