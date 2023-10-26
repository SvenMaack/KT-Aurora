package lib.base

import kotlin.test.Test
import kotlin.test.assertEquals

class AttributeFactoryTest {
    @Test
    fun `test attributes creation`() {
        val attribute: Attribute = "class"["className"]
        assertEquals("class", attribute.name)
        assertEquals("className", attribute.value)
    }

    @Test
    fun `test attributes creation with empty value`() {
        val attribute: Attribute = "class"[""]
        assertEquals("class", attribute.name)
        assertEquals("", attribute.value)
    }

    @Test
    fun `test attributes creation with empty name`() {
        val attribute: Attribute = ""["className"]
        assertEquals("", attribute.name)
        assertEquals("className", attribute.value)
    }
}
