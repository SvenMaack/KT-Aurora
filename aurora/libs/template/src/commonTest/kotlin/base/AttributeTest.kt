package template_lib.base

import kotlin.test.*

class AttributeTest {
    @Test
    fun `attributes creation`() {
        val attribute: Attribute = "class"["className"]
        assertEquals("class", attribute.name)
        assertEquals("className", attribute.value)
    }

    @Test
    fun `attributes creation with empty value`() {
        val attribute: Attribute = "class"[""]
        assertEquals("class", attribute.name)
        assertEquals("", attribute.value)
    }

    @Test
    fun `attributes creation with empty name`() {
        val attribute: Attribute = ""["className"]
        assertEquals("", attribute.name)
        assertEquals("className", attribute.value)
    }

    @Test
    fun `attributes creation with null value`() {
        val nullValue: String? = null
        val attribute: Attribute = "class"[nullValue]
        assertEquals("class", attribute.name)
        assertEquals(null, attribute.value)
    }
}
