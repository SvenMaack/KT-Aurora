package template_lib.tags

import io.mockative.*
import template_lib.base.TagWithAttributes
import template_lib.base.get
import kotlin.test.Test
import kotlin.test.assertEquals

class ListTest {
    @Mock
    val blockLi = mock(classOf<Callable<Li>>())

    @Test
    fun `test tag name is ol`() {
        val tag = Ol()
        assertEquals("ol", tag.name)
    }

    @Test
    fun `test tag name is ul`() {
        val tag = Ul()
        assertEquals("ul", tag.name)
    }

    @Test
    fun `test tag name is li`() {
        val tag = Li()
        assertEquals("li", tag.name)
    }

    @Test
    fun `test li function works inside of ul`() {
        val ul = Ul()
        val li = ul.li("a"["b"], clazz="clazz", init=blockLi::test)
        verification(li, blockLi)
    }

    @Test
    fun `test li function works inside of ol`() {
        val ol = Ol()
        val li = ol.li("a"["b"], clazz="clazz", init=blockLi::test)
        verification(li, blockLi)
    }

    private fun <Tag: TagWithAttributes>verification(tag: Tag, callable: Callable<Tag>) {
        verify { callable.test(tag) }
            .wasInvoked(exactly = once)

        assertEquals(mapOf(
            "a" to listOf("b"),
            "class" to listOf("clazz"),
        ), tag.attributes)
    }
}
