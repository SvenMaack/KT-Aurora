package css.properties

import css.base.Rule
import kotlin.test.Test
import kotlin.test.assertEquals

class ListStyleTest {
    @Test
    fun `list-style creates property`() {
        val rule = Rule("selector")
        rule.`list-style`(ListStyleTypeTextValue.circle, ListStylePositionTextValue.inside, inherit)
        assertEquals(1, rule.properties.size)
        assertEquals("list-style", rule.properties[0].property)
        assertEquals("circle inside inherit", rule.properties[0].value)
    }

    @Test
    fun `list-style creates property with image url`() {
        val rule = Rule("selector")
        rule.`list-style`(ListStyleTypeTextValue.circle, ListStylePositionTextValue.inside, "link")
        assertEquals(1, rule.properties.size)
        assertEquals("list-style", rule.properties[0].property)
        assertEquals("circle inside url(\"link\")", rule.properties[0].value)
    }

    @Test
    fun `list-style creates property without text`() {
        val rule = Rule("selector")
        rule.`list-style`(ListStylePositionTextValue.inside, inherit)
        assertEquals(1, rule.properties.size)
        assertEquals("list-style", rule.properties[0].property)
        assertEquals("inside inherit", rule.properties[0].value)
    }

    @Test
    fun `list-style creates property with image url without text`() {
        val rule = Rule("selector")
        rule.`list-style`(ListStylePositionTextValue.inside, "link")
        assertEquals(1, rule.properties.size)
        assertEquals("list-style", rule.properties[0].property)
        assertEquals("inside url(\"link\")", rule.properties[0].value)
    }

    @Test
    fun `list-style creates property without position`() {
        val rule = Rule("selector")
        rule.`list-style`(ListStyleTypeTextValue.circle, inherit as ListStyleImageValue)
        assertEquals(1, rule.properties.size)
        assertEquals("list-style", rule.properties[0].property)
        assertEquals("circle inherit", rule.properties[0].value)
    }

    @Test
    fun `list-style creates property with image url without position`() {
        val rule = Rule("selector")
        rule.`list-style`(ListStyleTypeTextValue.circle, "link")
        assertEquals(1, rule.properties.size)
        assertEquals("list-style", rule.properties[0].property)
        assertEquals("circle url(\"link\")", rule.properties[0].value)
    }

    @Test
    fun `list-style creates property without image`() {
        val rule = Rule("selector")
        rule.`list-style`(ListStyleTypeTextValue.circle, ListStylePositionTextValue.inside)
        assertEquals(1, rule.properties.size)
        assertEquals("list-style", rule.properties[0].property)
        assertEquals("circle inside", rule.properties[0].value)
    }

    @Test
    fun `list-style creates property with only image url`() {
        val rule = Rule("selector")
        rule.`list-style`("link")
        assertEquals(1, rule.properties.size)
        assertEquals("list-style", rule.properties[0].property)
        assertEquals("url(\"link\")", rule.properties[0].value)
    }

    @Test
    fun `list-style creates property with only image`() {
        val rule = Rule("selector")
        rule.`list-style`(inherit as ListStyleImageValue)
        assertEquals(1, rule.properties.size)
        assertEquals("list-style", rule.properties[0].property)
        assertEquals("inherit", rule.properties[0].value)
    }

    @Test
    fun `list-style creates property with only position`() {
        val rule = Rule("selector")
        rule.`list-style`(inherit as ListStylePositionValue)
        assertEquals(1, rule.properties.size)
        assertEquals("list-style", rule.properties[0].property)
        assertEquals("inherit", rule.properties[0].value)
    }

    @Test
    fun `list-style creates property with only type`() {
        val rule = Rule("selector")
        rule.`list-style` = inherit
        assertEquals(1, rule.properties.size)
        assertEquals("list-style", rule.properties[0].property)
        assertEquals("inherit", rule.properties[0].value)
    }
}
