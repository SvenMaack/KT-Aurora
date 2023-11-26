package template_lib.tags

import io.mockative.*
import template_lib.Callable
import template_lib.base.TagWithAttributes
import template_lib.base.get
import kotlin.test.Test
import kotlin.test.assertEquals

class ListTest {
    @Mock
    val blockLi = mock(classOf<Callable<Li>>())

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
        val li = ul.li("a"["b"], clazz="clazz", init=blockLi::test)
        verificationWithClass(li, blockLi)
    }

    @Test
    fun `li function works inside of ul without class`() {
        val ul = Ul()
        val li = ul.li("a"["b"], init=blockLi::test)
        verificationWithoutClass(li, blockLi)
    }

    @Test
    fun `li function works inside of ol`() {
        val ol = Ol()
        val li = ol.li("a"["b"], clazz="clazz", init=blockLi::test)
        verificationWithClass(li, blockLi)
    }

    @Test
    fun `li function works inside of ol without class`() {
        val ol = Ol()
        val li = ol.li("a"["b"], init=blockLi::test)
        verificationWithoutClass(li, blockLi)
    }

    @Test
    fun `li function works inside of menu`() {
        val menu = Menu()
        val li = menu.li("a"["b"], clazz="clazz", init=blockLi::test)
        verificationWithClass(li, blockLi)
    }

    @Test
    fun `li function works inside of menu without class`() {
        val menu = Menu()
        val li = menu.li("a"["b"], init=blockLi::test)
        verificationWithoutClass(li, blockLi)
    }

    private fun <Tag: TagWithAttributes>verificationWithClass(tag: Tag, callable: Callable<Tag>) {
        verify { callable.test(tag) }
            .wasInvoked(exactly = once)

        assertEquals(mapOf(
            "a" to listOf("b"),
            "class" to listOf("clazz"),
        ), tag.attributes)
    }

    private fun <Tag: TagWithAttributes> verificationWithoutClass(tag: Tag, callable: Callable<Tag>) {
        verify { callable.test(tag) }
            .wasInvoked(exactly = once)

        assertEquals(mapOf(
            "a" to listOf("b")
        ), tag.attributes)
    }
}
