package template.tags

import io.mockative.*
import kotlin.test.Test
import kotlin.test.assertEquals
import template.tags.enums.*

class HeadTest {
    @Mock
    val blockTitle = mock(classOf<Fun1<Title, Unit>>())
    @Mock
    val blockStyle = mock(classOf<Fun1<Style, Unit>>())

    @Test
    fun `tag name is head`() {
        val tag = Head()

        assertEquals("head", tag.name)
    }

    @Test
    fun `base function works with both parameters`() {
        val head = Head()

        val base = head.base(href = "link", target = Target.SELF)

        assertEquals(mapOf(
            "href" to listOf("link"),
            "target" to listOf(Target.SELF.value),
        ), base.attributes)
    }

    @Test
    fun `base function works with href`() {
        val head = Head()

        val base = head.base(href = "link")

        assertEquals(mapOf(
            "href" to listOf("link"),
        ), base.attributes)
    }

    @Test
    fun `base function works with target`() {
        val head = Head()

        val base = head.base(target = Target.SELF)

        assertEquals(mapOf(
            "target" to listOf(Target.SELF.value),
        ), base.attributes)
    }

    @Test
    fun `title function works`() {
        val head = Head()
        every { blockTitle.invoke(any()) }.returns(Unit)

        val title = head.title(init = blockTitle::invoke)

        verify { blockTitle.invoke(title) }
            .wasInvoked(exactly = once)
    }

    @Test
    fun `style function works`() {
        val head = Head()
        every { blockStyle.invoke(any()) }.returns(Unit)

        val style = head.style(init = blockStyle::invoke)

        verify { blockStyle.invoke(style) }
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

    @Test
    fun `meta name-HttpEquiv function works`() {
        val head = Head()
        val meta = head.metaHttpEquiv(content = "a")

        assertEquals(mapOf(
            "http-equiv" to listOf("content-type"),
            "content" to listOf("a")
        ), meta.attributes)
    }
}
