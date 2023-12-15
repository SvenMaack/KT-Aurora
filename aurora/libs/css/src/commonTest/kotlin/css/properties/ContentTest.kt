package css.properties

import css.base.BeforeAfterRule
import kotlin.test.Test
import kotlin.test.assertEquals

class ContentTest {
    @Test
    fun `content creates property`() {
        ContentTextValue.entries.forEach {
            val rule = BeforeAfterRule("selector")
            rule.content = it
            assertEquals(1, rule.properties.size)
            assertEquals("content", rule.properties[0].property)
            assertEquals(it.value, rule.properties[0].value)
        }
    }

    @Test
    fun `content creates url property`() {
        val rule = BeforeAfterRule("selector")
        rule.content = ContentUrl("www")
        assertEquals(1, rule.properties.size)
        assertEquals("content", rule.properties[0].property)
        assertEquals("url(www)", rule.properties[0].value)
    }

    @Test
    fun `content creates attribute property`() {
        val rule = BeforeAfterRule("selector")
        rule.content = ContentAttribute("abc")
        assertEquals(1, rule.properties.size)
        assertEquals("content", rule.properties[0].property)
        assertEquals("attr(abc)", rule.properties[0].value)
    }

    @Test
    fun `content creates custom property`() {
        val rule = BeforeAfterRule("selector")
        rule.content = ContentCustom("abc")
        assertEquals(1, rule.properties.size)
        assertEquals("content", rule.properties[0].property)
        assertEquals("abc", rule.properties[0].value)
    }

    @Test
    fun `content creates initial property`() {
        val rule = BeforeAfterRule("selector")
        rule.content = initial
        assertEquals(1, rule.properties.size)
        assertEquals("content", rule.properties[0].property)
        assertEquals("initial", rule.properties[0].value)
    }

    @Test
    fun `content creates inherit property`() {
        val rule = BeforeAfterRule("selector")
        rule.content = inherit
        assertEquals(1, rule.properties.size)
        assertEquals("content", rule.properties[0].property)
        assertEquals("inherit", rule.properties[0].value)
    }
}
