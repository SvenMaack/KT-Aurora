import com.squareup.wire.GrpcClient
import helloworld.GrpcGreeterClient
import landingPage.gateway.Error
import landingPage.gateway.LandingPage
import landingPage.server.Request
import landingPage.server.ResponseFunction
import landingPage.server.endpoints.CssEndpoint
import landingPage.server.endpoints.HtmlEndpoint
import landingPage.server.servers.KtorServer



public fun main() {
    val port = 8080
    println("Server will start at http://localhost:$port/?id=1")

    val grpcClient = GrpcClient.Builder()
        .client(OkHttpClient.Builder().protocols(listOf(Protocol.H2_PRIOR_KNOWLEDGE)).build())
        .baseUrl("localhost:8090")
        .build()
    val routeGuideClient = grpcClient.create(GrpcGreeterClient::class)

    /*
    KtorServer(port)
        .initEndpoint(HtmlEndpoint(
            path = "",
            block = { request: Request ->
                LandingPage.getHtml(
                    id = request.queryParameters["id"],
                    currentUrl = request.toUri()
                )
            },
            recover = { error: Error, response: ResponseFunction<String> ->
                response(error.errorCode, error.message)
            }
        ))
        .initEndpoint(CssEndpoint(
            path = "/${LandingPage.getExternalCssPath()}",
            css = LandingPage.getExternalCss()
        ))
        .start()

     */
}
