package css.properties

import css.base.Rule
import kotlin.test.Test
import kotlin.test.assertEquals

class TransformTest {
    @Test
    fun `transform inherit`() {
        val rule = Rule("selector")
        rule.transform = inherit
        assertEquals(1, rule.properties.size)
        checkProperty(rule, "inherit")
    }

    @Test
    fun `transform initial`() {
        val rule = Rule("selector")
        rule.transform = initial
        assertEquals(1, rule.properties.size)
        checkProperty(rule, "initial")
    }

    @Test
    fun `transform none`() {
        val rule = Rule("selector")
        rule.transform = none
        assertEquals(1, rule.properties.size)
        checkProperty(rule, "none")
    }

    @Test
    fun `transform matrix`() {
        val rule = Rule("selector")
        rule.transform = matrix(1.0, 2.0, 3.0, 4.0, 5.0, 6.0)
        assertEquals(1, rule.properties.size)
        checkProperty(rule, "matrix(1.0,2.0,3.0,4.0,5.0,6.0)")
    }

    @Test
    fun `transform translate`() {
        val rule = Rule("selector")
        rule.transform = translate(1.0, 2.0)
        assertEquals(1, rule.properties.size)
        checkProperty(rule, "translate(1.0,2.0)")
    }

    @Test
    fun `transform translateX`() {
        val rule = Rule("selector")
        rule.transform = translateX(1.0)
        assertEquals(1, rule.properties.size)
        checkProperty(rule, "translateX(1.0)")
    }

    @Test
    fun `transform translateY`() {
        val rule = Rule("selector")
        rule.transform = translateY(1.0)
        assertEquals(1, rule.properties.size)
        checkProperty(rule, "translateY(1.0)")
    }

    @Test
    fun `transform translateZ`() {
        val rule = Rule("selector")
        rule.transform = translateZ(1.0)
        assertEquals(1, rule.properties.size)
        checkProperty(rule, "translateZ(1.0)")
    }

    @Test
    fun `transform scale`() {
        val rule = Rule("selector")
        rule.transform = scale(1.0, 2.0)
        assertEquals(1, rule.properties.size)
        checkProperty(rule, "scale(1.0,2.0)")
    }

    @Test
    fun `transform scaleX`() {
        val rule = Rule("selector")
        rule.transform = scaleX(1.0)
        assertEquals(1, rule.properties.size)
        checkProperty(rule, "scaleX(1.0)")
    }

    @Test
    fun `transform scaleY`() {
        val rule = Rule("selector")
        rule.transform = scaleY(1.0)
        assertEquals(1, rule.properties.size)
        checkProperty(rule, "scaleY(1.0)")
    }

    @Test
    fun `transform scaleZ`() {
        val rule = Rule("selector")
        rule.transform = scaleZ(1.0)
        assertEquals(1, rule.properties.size)
        checkProperty(rule, "scaleZ(1.0)")
    }

    @Test
    fun `transform rotate`() {
        val rule = Rule("selector")
        rule.transform = rotate(1.0)
        assertEquals(1, rule.properties.size)
        checkProperty(rule, "rotate(1.0)")
    }

    @Test
    fun `transform rotateX`() {
        val rule = Rule("selector")
        rule.transform = rotateX(1.0)
        assertEquals(1, rule.properties.size)
        checkProperty(rule, "rotateX(1.0)")
    }

    @Test
    fun `transform rotateY`() {
        val rule = Rule("selector")
        rule.transform = rotateY(1.0)
        assertEquals(1, rule.properties.size)
        checkProperty(rule, "rotateY(1.0)")
    }

    @Test
    fun `transform rotateZ`() {
        val rule = Rule("selector")
        rule.transform = rotateZ(1.0)
        assertEquals(1, rule.properties.size)
        checkProperty(rule, "rotateZ(1.0)")
    }

    @Test
    fun `transform skew`() {
        val rule = Rule("selector")
        rule.transform = skew(1.0, 2.0)
        assertEquals(1, rule.properties.size)
        checkProperty(rule, "skew(1.0,2.0)")
    }

    @Test
    fun `transform skewX`() {
        val rule = Rule("selector")
        rule.transform = skewX(1.0)
        assertEquals(1, rule.properties.size)
        checkProperty(rule, "skewX(1.0)")
    }

    @Test
    fun `transform skewY`() {
        val rule = Rule("selector")
        rule.transform = skewY(1.0)
        assertEquals(1, rule.properties.size)
        checkProperty(rule, "skewY(1.0)")
    }

    @Test
    fun `transform perspective`() {
        val rule = Rule("selector")
        rule.transform = perspective(1.0)
        assertEquals(1, rule.properties.size)
        checkProperty(rule, "perspective(1.0)")
    }

    private fun checkProperty(rule: Rule, value: String) {
        assertEquals("-o-transform:$value;-moz-transform:$value;-webkit-transform:$value;transform:$value;", rule.properties[0].toString())
    }
}
