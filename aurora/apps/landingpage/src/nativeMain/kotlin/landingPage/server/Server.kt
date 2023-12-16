package landingPage.server

public interface Server {
    public fun <Error, Data>initEndpoint(endpoint: Endpoint<Error, Data>): Server
    public fun start()
}
