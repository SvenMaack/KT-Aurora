package server

import arrow.core.Either
import io.mockative.Fun1
import io.mockative.Mock
import io.mockative.any
import io.mockative.classOf
import io.mockative.every
import io.mockative.mock
import io.mockative.once
import io.mockative.verify
import kotlinx.coroutines.runBlocking
import server.servers.ServerHandler
import kotlin.test.BeforeTest
import kotlin.test.Test

class ServerHandlerTest {
    @Mock
    val logicalRecoverMock = mock(classOf<Fun1<String, Pair<HttpStatusCode, String>>>())
    val fatalRecoverMock = mock(classOf<Fun1<Throwable, Pair<HttpStatusCode, String>>>())
    val responseMock = mock(classOf<Fun1<String, Pair<HttpStatusCode, String>>>())

    @BeforeTest
    private fun initMocks() {
        every { logicalRecoverMock.invoke(any()) }.returns(HttpStatusCode.OK to "test")
        every { fatalRecoverMock.invoke(any()) }.returns(HttpStatusCode.InternalServerError to "test")
        every { responseMock.invoke(any()) }.returns(HttpStatusCode.OK to "test")
    }

    @Test
    fun `ktor transform works`() {
        runBlocking {
            ServerHandler<String, String>().handle(
                object: Endpoint<String, String> {
                    override val path: String = "/test"
                    override val httpMethod: HttpMethod = HttpMethod.Get
                    override val header: Map<String, String> = emptyMap()
                    override val executor: Executor<String, String> = Executor(
                        block = { Either.Right("test") },
                        logicalRecover = logicalRecoverMock::invoke,
                        fatalRecover = fatalRecoverMock::invoke,
                        response = responseMock::invoke,
                    )
                },
                Request(
                    queryParameters = emptyMap(),
                    path = "/test"
                )
            )

            verify { logicalRecoverMock.invoke(any()) }
                .wasNotInvoked()
            verify { fatalRecoverMock.invoke(any()) }
                .wasNotInvoked()
            verify { responseMock.invoke("test") }
                .wasInvoked(exactly = once)
        }
    }

    @Test
    fun `ktor logical error works`() {
        runBlocking {
            ServerHandler<String, String>().handle(
                object: Endpoint<String, String> {
                    override val path: String = "/test"
                    override val httpMethod: HttpMethod = HttpMethod.Get
                    override val header: Map<String, String> = emptyMap()
                    override val executor: Executor<String, String> = Executor(
                        block = { Either.Left("error") },
                        logicalRecover = logicalRecoverMock::invoke,
                        fatalRecover = fatalRecoverMock::invoke,
                        response = responseMock::invoke,
                    )
                },
                Request(
                    queryParameters = emptyMap(),
                    path = "/test"
                )
            )

            verify { logicalRecoverMock.invoke("error") }
                .wasInvoked(exactly = once)
            verify { fatalRecoverMock.invoke(any()) }
                .wasNotInvoked()
            verify { responseMock.invoke(any()) }
                .wasNotInvoked()
        }
    }

    @Test
    fun `ktor fatal error works`() {
        val throwable = Throwable("error")
        runBlocking {
            ServerHandler<String, String>().handle(
                object: Endpoint<String, String> {
                    override val path: String = "/test"
                    override val httpMethod: HttpMethod = HttpMethod.Get
                    override val header: Map<String, String> = emptyMap()
                    override val executor: Executor<String, String> = Executor(
                        block = { throw throwable },
                        logicalRecover = logicalRecoverMock::invoke,
                        fatalRecover = fatalRecoverMock::invoke,
                        response = responseMock::invoke,
                    )
                },
                Request(
                    queryParameters = emptyMap(),
                    path = "/test"
                )
            )

            verify { logicalRecoverMock.invoke(any()) }
                .wasNotInvoked()
            verify { fatalRecoverMock.invoke(throwable) }
                .wasInvoked(exactly = once)
            verify { responseMock.invoke(any()) }
                .wasNotInvoked()
        }
    }

    @Test
    fun `ktor fatal error in response works`() {
        val throwable = Throwable("error")
        runBlocking {
            ServerHandler<String, String>().handle(
                object: Endpoint<String, String> {
                    override val path: String = "/test"
                    override val httpMethod: HttpMethod = HttpMethod.Get
                    override val header: Map<String, String> = emptyMap()
                    override val executor: Executor<String, String> = Executor(
                        block = { Either.Right("test") },
                        logicalRecover = logicalRecoverMock::invoke,
                        fatalRecover = fatalRecoverMock::invoke,
                        response = { throw throwable }
                    )
                },
                Request(
                    queryParameters = emptyMap(),
                    path = "/test"
                )
            )

            verify { logicalRecoverMock.invoke(any()) }
                .wasNotInvoked()
            verify { fatalRecoverMock.invoke(throwable) }
                .wasInvoked(exactly = once)
        }
    }
}
