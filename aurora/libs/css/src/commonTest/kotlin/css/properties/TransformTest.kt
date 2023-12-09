package css.properties

import css.base.Rule
import kotlin.test.Test
import kotlin.test.assertEquals

class TransformTest {
    @Test
    fun `transform basics`() {
        TransformBasics.entries.forEach {
            val rule = Rule("selector")
            rule.transform2D(it)
            assertEquals(1, rule.properties.size)
            checkProperty(rule, it.value)
        }
    }

    @Test
    fun `transform matrix`() {
        val rule = Rule("selector")
        rule.transform2D(Matrix(1.0, 2.0, 3.0, 4.0, 5.0, 6.0))
        assertEquals(1, rule.properties.size)
        checkProperty(rule, "matrix(1.0,2.0,3.0,4.0,5.0,6.0)")
    }

    @Test
    fun `transform translate`() {
        val rule = Rule("selector")
        rule.transform2D(Translate(1.0, 2.0))
        assertEquals(1, rule.properties.size)
        checkProperty(rule, "translate(1.0,2.0)")
    }

    @Test
    fun `transform translateX`() {
        val rule = Rule("selector")
        rule.transform2D(TranslateX(1.0))
        assertEquals(1, rule.properties.size)
        checkProperty(rule, "translateX(1.0)")
    }

    @Test
    fun `transform translateY`() {
        val rule = Rule("selector")
        rule.transform2D(TranslateY(1.0))
        assertEquals(1, rule.properties.size)
        checkProperty(rule, "translateY(1.0)")
    }

    @Test
    fun `transform translateZ`() {
        val rule = Rule("selector")
        rule.transform2D(TranslateZ(1.0))
        assertEquals(1, rule.properties.size)
        checkProperty(rule, "translateZ(1.0)")
    }

    @Test
    fun `transform scale`() {
        val rule = Rule("selector")
        rule.transform2D(Scale(1.0, 2.0))
        assertEquals(1, rule.properties.size)
        checkProperty(rule, "scale(1.0,2.0)")
    }

    @Test
    fun `transform scaleX`() {
        val rule = Rule("selector")
        rule.transform2D(ScaleX(1.0))
        assertEquals(1, rule.properties.size)
        checkProperty(rule, "scaleX(1.0)")
    }

    @Test
    fun `transform scaleY`() {
        val rule = Rule("selector")
        rule.transform2D(ScaleY(1.0))
        assertEquals(1, rule.properties.size)
        checkProperty(rule, "scaleY(1.0)")
    }

    @Test
    fun `transform scaleZ`() {
        val rule = Rule("selector")
        rule.transform2D(ScaleZ(1.0))
        assertEquals(1, rule.properties.size)
        checkProperty(rule, "scaleZ(1.0)")
    }

    @Test
    fun `transform rotate`() {
        val rule = Rule("selector")
        rule.transform2D(Rotate(1.0))
        assertEquals(1, rule.properties.size)
        checkProperty(rule, "rotate(1.0)")
    }

    @Test
    fun `transform rotateX`() {
        val rule = Rule("selector")
        rule.transform2D(RotateX(1.0))
        assertEquals(1, rule.properties.size)
        checkProperty(rule, "rotateX(1.0)")
    }

    @Test
    fun `transform rotateY`() {
        val rule = Rule("selector")
        rule.transform2D(RotateY(1.0))
        assertEquals(1, rule.properties.size)
        checkProperty(rule, "rotateY(1.0)")
    }

    @Test
    fun `transform rotateZ`() {
        val rule = Rule("selector")
        rule.transform2D(RotateZ(1.0))
        assertEquals(1, rule.properties.size)
        checkProperty(rule, "rotateZ(1.0)")
    }

    @Test
    fun `transform skew`() {
        val rule = Rule("selector")
        rule.transform2D(Skew(1.0, 2.0))
        assertEquals(1, rule.properties.size)
        checkProperty(rule, "skew(1.0,2.0)")
    }

    @Test
    fun `transform skewX`() {
        val rule = Rule("selector")
        rule.transform2D(SkewX(1.0))
        assertEquals(1, rule.properties.size)
        checkProperty(rule, "skewX(1.0)")
    }

    @Test
    fun `transform skewY`() {
        val rule = Rule("selector")
        rule.transform2D(SkewY(1.0))
        assertEquals(1, rule.properties.size)
        checkProperty(rule, "skewY(1.0)")
    }

    @Test
    fun `transform perspective`() {
        val rule = Rule("selector")
        rule.transform2D(Perspective(1.0))
        assertEquals(1, rule.properties.size)
        checkProperty(rule, "perspective(1.0)")
    }

    private fun checkProperty(rule: Rule, value: String) {
        assertEquals("-o-transform:$value;-moz-transform:$value;-webkit-transform:$value;transform:$value;", rule.properties[0].toString())
    }
}
