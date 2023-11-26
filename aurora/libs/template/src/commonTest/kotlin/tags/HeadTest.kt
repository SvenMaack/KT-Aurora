package template_lib.tags

import io.mockative.*
import template_lib.Callable
import kotlin.test.Test
import kotlin.test.assertEquals

class HeadTest {
    @Mock
    val blockTitle = mock(classOf<Callable<Title>>())
    @Mock
    val blockStyle = mock(classOf<Callable<Style>>())

    @Test
    fun `tag name is head`() {
        val tag = Head()
        assertEquals("head", tag.name)
    }

    @Test
    fun `title function works`() {
        val head = Head()
        val title = head.title(init = blockTitle::test)

        verify { blockTitle.test(title) }
            .wasInvoked(exactly = once)
    }

    @Test
    fun `style function works`() {
        val head = Head()
        val style = head.style(init = blockStyle::test)

        verify { blockStyle.test(style) }
            .wasInvoked(exactly = once)
    }

    @Test
    fun `link function works`() {
        val head = Head()
        val link = head.link(rel="a", href="b")

        assertEquals(mapOf(
            "rel" to listOf("a"),
            "href" to listOf("b"),
        ), link.attributes)
    }

    @Test
    fun `meta charset function works`() {
        val head = Head()
        val meta = head.meta(charset = "test")

        assertEquals(mapOf(
            "charset" to listOf("test"),
        ), meta.attributes)
    }

    @Test
    fun `meta name-content function works`() {
        val head = Head()
        val meta = head.meta(name = "name", content = "content")

        assertEquals(mapOf(
            "name" to listOf("name"),
            "content" to listOf("content")
        ), meta.attributes)
    }
}
