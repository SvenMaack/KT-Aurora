package server

import kotlin.test.Test
import kotlin.test.assertEquals

class RequestTest {
    @Test
    fun `uri without parameters works`() {
        val request = Request(
            queryParameters = emptyMap(),
            path = "/test",
        )
        assertEquals("/test", request.toUri())
    }

    @Test
    fun `uri with parameters works`() {
        val request = Request(
            queryParameters = mapOf("a" to "1", "b" to "2"),
            path = "/test",
        )
        assertEquals("/test?a=1&b=2", request.toUri())
    }
}
