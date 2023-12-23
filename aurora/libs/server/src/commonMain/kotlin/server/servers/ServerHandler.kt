package server.servers

import arrow.core.raise.catch
import arrow.core.raise.fold
import server.Endpoint
import server.Request

public class ServerHandler<Error, Data> {
    public suspend fun handle(
        endpoint: Endpoint<Error, Data>,
        request: Request
    ): Pair<server.HttpStatusCode, String> =
        catch({
            fold(
                block = {
                    endpoint.executor.block(request).bind()
                },
                recover = { error: Error ->
                    endpoint.executor.logicalRecover(error)
                },
                transform = { data: Data ->
                    endpoint.executor.response(data)
                },
                catch = { error: Throwable ->
                    endpoint.executor.fatalRecover(error)
                },
            )
        }) { error ->
            endpoint.executor.fatalRecover(error)
        }
}
