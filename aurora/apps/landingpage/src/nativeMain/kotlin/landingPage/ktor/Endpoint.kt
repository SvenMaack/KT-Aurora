package landingPage.ktor

import arrow.core.Either

public typealias ResponseFunction<T> = suspend (HttpStatusCode, T) -> Unit

public data class Executor<Error, Data>(
    val block: suspend (Request) -> Either<Error, Data>,
    val recover: suspend (Error, ResponseFunction<String>) -> Unit,
    val response: suspend (Data, ResponseFunction<String>) -> Unit
)

public interface Endpoint<Error, Data> {
    public val path: String
    public val httpMethod: HttpMethod
    public val header: Map<String, String>
    public val executor: Executor<Error, Data>
}
