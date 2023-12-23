package server

import me.tatarka.inject.annotations.Component
import me.tatarka.inject.annotations.Provides
import server.servers.KtorServer

@Component
public abstract class ServerComponent {
    public abstract val server: Server

    protected val KtorServer.bind: Server
        @Provides get() = this
}
