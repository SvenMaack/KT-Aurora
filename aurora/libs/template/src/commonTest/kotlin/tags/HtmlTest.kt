package template_lib.tags

import io.mockative.*
import template_lib.Callable
import template_lib.base.Visitor
import kotlin.test.Test
import kotlin.test.assertEquals

class HtmlTest {
    @Mock
    val blockHead = mock(classOf<Callable<Head>>())
    @Mock
    val blockBody = mock(classOf<Callable<Body>>())
    @Mock
    val visitor = mock(classOf<Visitor<String>>())
    @Mock
    val blockHtml = mock(classOf<Callable<Html>>())

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

    @Test
    fun `DocType is added`() {
        val html = Html()

        html.traverse(visitor)

        verify { visitor.visitTag(DocType) }
            .wasInvoked(exactly = once)
    }

    @Test
    fun `html function works`() {
        val html = html(lang="en", dir=Direction.LTR, blockHtml::test)

        assertEquals("html", html.name)

        verify { blockHtml.test(html) }
            .wasInvoked(exactly = once)

        assertEquals(mapOf(
            "lang" to listOf("en"),
            "dir" to listOf("ltr"),
        ), html.attributes)
    }
}
