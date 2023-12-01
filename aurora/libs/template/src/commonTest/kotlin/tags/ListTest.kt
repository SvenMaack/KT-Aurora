package template_lib.tags

import io.mockative.*
import template_lib.Callable
import template_lib.base.TagWithAttributes
import template_lib.base.get
import kotlin.test.Test
import kotlin.test.assertEquals

class ListTest {
    @Mock
    val blockLi = mock(classOf<Fun1<Li, Unit>>())

    @Test
    fun `tag name is ol`() {
        val tag = Ol()

        assertEquals("ol", tag.name)
    }

    @Test
    fun `tag name is ul`() {
        val tag = Ul()

        assertEquals("ul", tag.name)
    }

    @Test
    fun `tag name is menu`() {
        val tag = Menu()

        assertEquals("menu", tag.name)
    }

    @Test
    fun `tag name is li`() {
        val tag = Li()

        assertEquals("li", tag.name)
    }

    @Test
    fun `li function works inside of ul`() {
        val ul = Ul()
        every { blockLi.invoke(any()) }.returns(Unit)

        val li = ul.li("a"["b"], clazz="clazz", init=blockLi::invoke)

        verificationWithClass(li, blockLi)
    }

    @Test
    fun `li function works inside of ul without class`() {
        val ul = Ul()
        every { blockLi.invoke(any()) }.returns(Unit)

        val li = ul.li("a"["b"], init=blockLi::invoke)

        verificationWithoutClass(li, blockLi)
    }

    @Test
    fun `li function works inside of ol`() {
        val ol = Ol()
        every { blockLi.invoke(any()) }.returns(Unit)

        val li = ol.li("a"["b"], clazz="clazz", init=blockLi::invoke)

        verificationWithClass(li, blockLi)
    }

    @Test
    fun `li function works inside of ol without class`() {
        val ol = Ol()
        every { blockLi.invoke(any()) }.returns(Unit)

        val li = ol.li("a"["b"], init=blockLi::invoke)

        verificationWithoutClass(li, blockLi)
    }

    @Test
    fun `li function works inside of menu`() {
        val menu = Menu()
        every { blockLi.invoke(any()) }.returns(Unit)

        val li = menu.li("a"["b"], clazz="clazz", init=blockLi::invoke)

        verificationWithClass(li, blockLi)
    }

    @Test
    fun `li function works inside of menu without class`() {
        val menu = Menu()
        every { blockLi.invoke(any()) }.returns(Unit)

        val li = menu.li("a"["b"], init=blockLi::invoke)

        verificationWithoutClass(li, blockLi)
    }

    private fun <Tag: TagWithAttributes>verificationWithClass(tag: Tag, callable: Fun1<Tag, Unit>) {
        verify { callable.invoke(tag) }
            .wasInvoked(exactly = once)

        assertEquals(mapOf(
            "a" to listOf("b"),
            "class" to listOf("clazz"),
        ), tag.attributes)
    }

    private fun <Tag: TagWithAttributes> verificationWithoutClass(tag: Tag, callable: Fun1<Tag, Unit>) {
        verify { callable.invoke(tag) }
            .wasInvoked(exactly = once)

        assertEquals(mapOf(
            "a" to listOf("b")
        ), tag.attributes)
    }
}
