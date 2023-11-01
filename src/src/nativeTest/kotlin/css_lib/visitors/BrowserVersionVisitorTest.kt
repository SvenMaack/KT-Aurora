package css_lib.visitors

import css_lib.base.Property
import css_lib.base.Rule
import css_lib.base.browser.Chrome
import css_lib.base.browser.Firefox
import kotlin.test.Test
import kotlin.test.assertEquals

class BrowserVersionVisitorTest {
    @Test
    fun `version calculated correctly`() {
        val rule = Rule("selector").apply {
            +Property.build(
                "property1",
                "value",
                "0",
                listOf(
                    Chrome { 1.0 },
                    Firefox { 2.0 }
                )
            )
            +Property.build(
                "property2",
                "value",
                "0",
                listOf(
                    Chrome { 3.0 },
                    Firefox { 1.0 }
                )
            )
        }

        val visitor = BrowserVersionVisitor()
        val result = visitor.visitRule(rule).result

        assertEquals(2, result.size)
        assertEquals(3.0, result["chrome"])
        assertEquals(2.0, result["firefox"])
    }

    @Test
    fun `version calculated correctly with missing browser`() {
        val rule = Rule("selector").apply {
            +Property.build(
                "property1",
                "value",
                "0",
                listOf(
                    Chrome { 1.0 },
                    Firefox { 2.0 }
                )
            )
            +Property.build(
                "property2",
                "value",
                "0",
                listOf(
                    Chrome { 3.0 }
                )
            )
        }

        val visitor = BrowserVersionVisitor()
        val result = visitor.visitRule(rule).result

        assertEquals(2, result.size)
        assertEquals(3.0, result["chrome"])
        assertEquals(2.0, result["firefox"])
    }
}
