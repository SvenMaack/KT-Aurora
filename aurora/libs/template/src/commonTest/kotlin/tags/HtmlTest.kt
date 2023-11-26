package template_lib.tags

import io.mockative.*
import template_lib.Callable
import template_lib.base.HtmlVisitor
import template_lib.tags.enums.GeneralLanguage
import kotlin.test.Test
import kotlin.test.assertEquals

class HtmlTest {
    @Mock
    val blockHead = mock(classOf<Callable<Head>>())
    @Mock
    val blockBody = mock(classOf<Callable<Body>>())
    @Mock
    val htmlVisitor = mock(classOf<HtmlVisitor<String>>())
    @Mock
    val blockHtml = mock(classOf<Callable<Html>>())

    @Test
    fun `tag name is html`() {
        val tag = Html()
        assertEquals("html", tag.name)
    }

    @Test
    fun `head function works`() {
        val html = Html()
        val title = html.head(init = blockHead::test)

        verify { blockHead.test(title) }
            .wasInvoked(exactly = once)
    }

    @Test
    fun `body function works`() {
        val html = Html()
        val body = html.body(init = blockBody::test)

        verify { blockBody.test(body) }
            .wasInvoked(exactly = once)
    }

    @Test
    fun `DocType is added`() {
        val html = Html()

        html.traverse(htmlVisitor)

        verify { htmlVisitor.visitTag(DocType) }
            .wasInvoked(exactly = once)
    }

    @Test
    fun `html function works`() {
        val html = html(lang=GeneralLanguage.English, dir=Direction.LTR, init = blockHtml::test)

        assertEquals("html", html.name)

        verify { blockHtml.test(html) }
            .wasInvoked(exactly = once)

        assertEquals(mapOf(
            "lang" to listOf(GeneralLanguage.English.value),
            "dir" to listOf("ltr"),
        ), html.attributes)
    }

    @Test
    fun `html function works with namespace`() {
        val html = html(lang=GeneralLanguage.English, dir=Direction.LTR, xmlns = "test", blockHtml::test)

        assertEquals("html", html.name)

        verify { blockHtml.test(html) }
            .wasInvoked(exactly = once)

        assertEquals(mapOf(
            "lang" to listOf(GeneralLanguage.English.value),
            "dir" to listOf("ltr"),
            "xmlns" to listOf("test"),
        ), html.attributes)
    }
}
