package css.properties

import css.base.Rule
import kotlin.test.Test
import kotlin.test.assertEquals

class ListStyleImageTest {
    @Test
    fun `list-style-image creates property`() {
        ListStyleImageTextValue.entries.forEach {
            val rule = Rule("selector")
            rule.`list-style-image` = it
            assertEquals(1, rule.properties.size)
            assertEquals("list-style-image", rule.properties[0].property)
            assertEquals(it.value, rule.properties[0].value)
        }
    }

    @Test
    fun `list-style-image creates initial property`() {
        val rule = Rule("selector")
        rule.`list-style-image` = initial
        assertEquals(1, rule.properties.size)
        assertEquals("list-style-image", rule.properties[0].property)
        assertEquals("initial", rule.properties[0].value)
    }

    @Test
    fun `list-style-image creates inherit property`() {
        val rule = Rule("selector")
        rule.`list-style-image` = inherit
        assertEquals(1, rule.properties.size)
        assertEquals("list-style-image", rule.properties[0].property)
        assertEquals("inherit", rule.properties[0].value)
    }

    @Test
    fun `list-style-image creates property with url`() {
        val rule = Rule("selector")
        rule.`list-style-image`("www")
        assertEquals(1, rule.properties.size)
        assertEquals("list-style-image", rule.properties[0].property)
        assertEquals("url(\"www\")", rule.properties[0].value)
    }
}
