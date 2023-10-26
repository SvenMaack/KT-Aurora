package lib.tags

import io.mockative.*
import kotlin.test.Test
import kotlin.test.assertEquals

class HtmlTest {
    @Mock
    val blockHead = mock(classOf<Callable<Head>>())
    @Mock
    val blockBody = mock(classOf<Callable<Body>>())

    @Test
    fun `test tag name is html`() {
        val tag = Html()
        assertEquals("html", tag.name)
    }

    @Test
    fun `test head function works`() {
        val html = Html()
        val title = html.head(init = blockHead::test)

        verify { blockHead.test(title) }
            .wasInvoked(exactly = once)
    }

    @Test
    fun `test body function works`() {
        val html = Html()
        val body = html.body(init = blockBody::test)

        verify { blockBody.test(body) }
            .wasInvoked(exactly = once)
    }
}
