package template.tags

import io.mockative.*
import template.base.*
import kotlin.test.Test
import kotlin.test.assertEquals

class ArticleTest {
    @Mock
    val blockHeader = mock(classOf<Fun1<Header, Unit>>())

    @Test
    fun `tag name is article`() {
        val tag = Article()
        assertEquals("article", tag.name)
    }

    @Test
    fun `p function works`() {
        val tag = Article()
        every { blockHeader.invoke(any()) }.returns(Unit)

        val header = tag.header("a"["b"], clazz="clazz", init=blockHeader::invoke)

        verify { blockHeader.invoke(header) }
            .wasInvoked(exactly = once)
        assertEquals(mapOf(
            "a" to listOf("b"),
            "class" to listOf("clazz"),
        ), header.attributes)
    }

    @Test
    fun `p function works without class`() {
        val tag = Article()
        every { blockHeader.invoke(any()) }.returns(Unit)

        val header = tag.header("a"["b"], init=blockHeader::invoke)

        verify { blockHeader.invoke(header) }
            .wasInvoked(exactly = once)

        assertEquals(mapOf(
            "a" to listOf("b")
        ), header.attributes)
    }
}
