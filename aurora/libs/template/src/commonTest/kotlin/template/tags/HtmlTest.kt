package template.tags

import io.mockative.*
import template.base.HtmlVisitor
import template.tags.enums.GeneralLanguage
import kotlin.test.Test
import kotlin.test.assertEquals

class HtmlTest {
    @Mock
    val blockHead = mock(classOf<Fun1<Head, Unit>>())
    @Mock
    val blockBody = mock(classOf<Fun1<Body, Unit>>())
    @Mock
    val htmlVisitor = mock(classOf<HtmlVisitor<String>>())
    @Mock
    val blockHtml = mock(classOf<Fun1<Html, Unit>>())

    @Test
    fun `tag name is html`() {
        val tag = Html()

        assertEquals("html", tag.name)
    }

    @Test
    fun `head function works`() {
        val html = Html()
        every { blockHead.invoke(any()) }.returns(Unit)

        val title = html.head(init = blockHead::invoke)

        verify { blockHead.invoke(title) }
            .wasInvoked(exactly = once)
    }

    @Test
    fun `body function works`() {
        val html = Html()
        every { blockBody.invoke(any()) }.returns(Unit)

        val body = html.body(init = blockBody::invoke)

        verify { blockBody.invoke(body) }
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
        every { blockHtml.invoke(any()) }.returns(Unit)

        val html = html(lang=GeneralLanguage.English, dir=Direction.LTR, init = blockHtml::invoke)

        assertEquals("html", html.name)
        verify { blockHtml.invoke(html) }
            .wasInvoked(exactly = once)
        assertEquals(mapOf(
            "lang" to listOf(GeneralLanguage.English.value),
            "dir" to listOf("ltr"),
        ), html.attributes)
    }

    @Test
    fun `html function works with namespace`() {
        every { blockHtml.invoke(any()) }.returns(Unit)

        val html = html(lang=GeneralLanguage.English, dir=Direction.LTR, xmlns = "test", blockHtml::invoke)

        assertEquals("html", html.name)

        verify { blockHtml.invoke(html) }
            .wasInvoked(exactly = once)

        assertEquals(mapOf(
            "lang" to listOf(GeneralLanguage.English.value),
            "dir" to listOf("ltr"),
            "xmlns" to listOf("test"),
        ), html.attributes)
    }
}
