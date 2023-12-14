package css.properties

import css.base.Rule
import kotlin.test.Test
import kotlin.test.assertEquals

class ContentTest {
    @Test
    fun content() {
        ContentTextValue.entries.forEach {
            val rule = Rule("selector")
            rule.content(it)
            assertEquals(1, rule.properties.size)
            assertEquals("content", rule.properties[0].property)
            assertEquals(it.value, rule.properties[0].value)
        }
    }

    @Test
    fun `content url`() {
        val rule = Rule("selector")
        rule.content(ContentUrl("www"))
        assertEquals(1, rule.properties.size)
        assertEquals("content", rule.properties[0].property)
        assertEquals("url(www)", rule.properties[0].value)
    }

    @Test
    fun `content attribute`() {
        val rule = Rule("selector")
        rule.content(ContentAttribute("www"))
        assertEquals(1, rule.properties.size)
        assertEquals("content", rule.properties[0].property)
        assertEquals("attr(www)", rule.properties[0].value)
    }

    @Test
    fun `content own text`() {
        val rule = Rule("selector")
        rule.content("test")
        assertEquals(1, rule.properties.size)
        assertEquals("content", rule.properties[0].property)
        assertEquals("test", rule.properties[0].value)
    }
}
