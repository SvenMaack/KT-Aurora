package css_lib.properties

import css_lib.base.Rule
import kotlin.test.Test
import kotlin.test.assertEquals

class ListTest {
    @Test
    fun `test list-style-type`() {
        ListStyleTypeValue.entries.forEach {
            val rule = Rule("selector")
            rule.`list-style-type`(it)
            checkType(rule, it)
        }
    }

    @Test
    fun `test list-style-position`() {
        ListStylePositionValue.entries.forEach {
            val rule = Rule("selector")
            rule.`list-style-position`(it)
            checkPosition(rule, it)
        }
    }

    @Test
    fun `test list-style-image`() {
        ListStyleImageValue.entries.forEach {
            val rule = Rule("selector")
            rule.`list-style-image`(it)
            checkImage(rule, it)
        }
    }

    @Test
    fun `test list-style-image-url`() {
        val rule = Rule("selector")
        rule.`list-style-image`("link")
        checkImage(rule, "url(\"link\")")
    }

    @Test
    fun `test list-style`() {
        val rule = Rule("selector")
        rule.`list-style`(ListStyleTypeValue.circle, ListStylePositionValue.inside, "link")
        assertEquals(1, rule.properties.size)
        assertEquals("list-style", rule.properties[0].property)
        assertEquals("circle inside url(\"link\")", rule.properties[0].value)
    }

    @Test
    fun `test list-style with null values`() {
        val rule = Rule("selector")
        rule.`list-style`(ListStyleTypeValue.circle)
        assertEquals(1, rule.properties.size)
        assertEquals("list-style", rule.properties[0].property)
        assertEquals("circle", rule.properties[0].value)
    }

    private fun checkType(rule: Rule, type: ListStyleTypeValue) {
        assertEquals(1, rule.properties.size)
        assertEquals("list-style-type", rule.properties[0].property)
        assertEquals(type.value, rule.properties[0].value)
    }

    private fun checkPosition(rule: Rule, position: ListStylePositionValue) {
        assertEquals(1, rule.properties.size)
        assertEquals("list-style-position", rule.properties[0].property)
        assertEquals(position.value, rule.properties[0].value)
    }

    private fun checkImage(rule: Rule, image: ListStyleImageValue) {
        assertEquals(1, rule.properties.size)
        assertEquals("list-style-image", rule.properties[0].property)
        assertEquals(image.value, rule.properties[0].value)
    }

    private fun checkImage(rule: Rule, image: String) {
        assertEquals(1, rule.properties.size)
        assertEquals("list-style-image", rule.properties[0].property)
        assertEquals(image, rule.properties[0].value)
    }
}
