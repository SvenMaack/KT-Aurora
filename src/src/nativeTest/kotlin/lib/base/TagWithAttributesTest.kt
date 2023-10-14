package lib.base

import io.mockative.configure
import io.mockative.Mock
import io.mockative.mock
import io.mockative.classOf
import io.mockative.verify
import io.mockative.time
import kotlin.test.Test
import kotlin.test.assertEquals

@Suppress("FunctionNaming")
class TagWithAttributesTest {
    @Mock
    val api = configure(mock(classOf<Visitor>())) {
        stubsUnitByDefault = true
    }

    @Test
    fun `tag is set correctly`() {
        assertEquals("p", TagWithAttributes("p").tagName)
    }

    @Test
    fun `tag without content is set to empty`() {
        assertEquals("empty", TagWithAttributes("").tagName)
    }

    @Test
    fun `tag is trimmed`() {
        assertEquals("p", TagWithAttributes(" p").tagName)
        assertEquals("p", TagWithAttributes("p ").tagName)
        assertEquals("p", TagWithAttributes(" p ").tagName)
    }

    @Test
    fun `tag removes special chars`() {
        assertEquals("p", TagWithAttributes("<§p>").tagName)
        assertEquals("empty", TagWithAttributes("<§>").tagName)
    }

    @Test
    fun `tag is lower string`() {
        assertEquals("p", TagWithAttributes("P").tagName)
    }

    @Test
    fun `attributes are set`() {
        val attributes = arrayOf(object : Attribute {
            override val name: String = "a"
            override val value: String = "b"
        })
        val expectedResult = mapOf(
            "a" to listOf("b")
        )
        assertEquals(expectedResult, TagWithAttributes("P").setAttributes(*attributes).attributes)
    }

    @Test
    fun `attributes are only set once`() {
        val attributes = arrayOf(object : Attribute {
            override val name: String = "same"
            override val value: String = "a"
        }, object : Attribute {
            override val name: String = "other"
            override val value: String = "b"
        }, object : Attribute {
            override val name: String = "same"
            override val value: String = "c"
        })
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
        tagWithAttributes.traverse(api)
        verify(api)
            .invocation {
                visitTagWithAttributes(tagWithAttributes)
            }
            .wasInvoked(exactly = 1.time)
    }
}