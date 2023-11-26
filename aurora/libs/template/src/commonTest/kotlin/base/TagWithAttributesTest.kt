package template_lib.base

import io.mockative.*
import kotlin.test.Test
import kotlin.test.assertEquals

class TagWithAttributesTest {
    @Mock
    val htmlVisitor = mock(classOf<HtmlVisitor<String>>())

    @Test
    fun `tag is set correctly`() {
        assertEquals("p", TagWithAttributes("p").name)
    }

    @Test
    fun `tag without content is set to empty`() {
        assertEquals("empty", TagWithAttributes("").name)
    }

    @Test
    fun `tag is trimmed`() {
        assertEquals("p", TagWithAttributes(" p").name)
        assertEquals("p", TagWithAttributes("p ").name)
        assertEquals("p", TagWithAttributes(" p ").name)
    }

    @Test
    fun `tag removes special chars`() {
        assertEquals("p", TagWithAttributes("<§p>").name)
        assertEquals("empty", TagWithAttributes("<§>").name)
    }

    @Test
    fun `tag is lower string`() {
        assertEquals("p", TagWithAttributes("P").name)
    }

    @Test
    fun `attributes are set`() {
        val attributes = arrayOf(AttributeWithValueImpl("a", "b"))
        val expectedResult = mapOf(
            "a" to listOf("b")
        )
        assertEquals(expectedResult, TagWithAttributes("P").setAttributes(*attributes).attributes)
    }

    @Test
    fun `attributes are only set once`() {
        val attributes = arrayOf(
            AttributeWithValueImpl("same", "a"),
            AttributeWithValueImpl("other", "b"),
            AttributeWithValueImpl("same", "c")
        )
        val expectedResult = mapOf(
            "same" to listOf("a", "c"),
            "other" to listOf("b")
        )
        assertEquals(expectedResult, TagWithAttributes("P").setAttributes(*attributes).attributes)
    }

    @Test
    fun `attributes can be set empty`() {
        val attributes = arrayOf<Attribute>()
        assertEquals(mapOf(), TagWithAttributes("P").setAttributes(*attributes).attributes)
    }

    @Test
    fun `visitor is being called`() {
        val tagWithAttributes = TagWithAttributes("a")

        tagWithAttributes.traverse(htmlVisitor)

        verify { htmlVisitor.visitTagWithAttributes(tagWithAttributes) }
            .wasInvoked(exactly = once)
        verify { htmlVisitor.visitTag(tagWithAttributes) }
            .wasNotInvoked()
    }
}
