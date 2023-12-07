package template.base

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

    @Test
    fun `attributes creation with several values`() {
        val value1: String = "v1"
        val value2: String = "v2"
        val attribute: Attribute = "class"[value1, value2]
        assertEquals("class", attribute.name)
        assertEquals("$value1 $value2", attribute.value)
    }

    @Test
    fun `attributes creation with several optional values`() {
        val value1: String = "v1"
        val value2: String? = null
        val attribute: Attribute = "class"[value1, value2]
        assertEquals("class", attribute.name)
        assertEquals(value1, attribute.value)
    }

    @Test
    fun `attributes creation with several null values`() {
        val value1: String? = null
        val value2: String? = null
        val attribute: Attribute = "class"[value1, value2]
        assertEquals("class", attribute.name)
        assertEquals(value1, null)
    }

    @Test
    fun `optional string`() {
        val value: String = "v1"
        val result: String? = value%true
        assertEquals(value, result)
    }

    @Test
    fun `optional string with false value`() {
        val value: String = "v1"
        val result: String? = value%false
        assertEquals(null, result)
    }
}
