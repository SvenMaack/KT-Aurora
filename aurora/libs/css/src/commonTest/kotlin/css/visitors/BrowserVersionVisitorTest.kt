package css.visitors

import css.base.Property
import css.base.Rule
import css.base.browser.NOT_SUPPORTED
import css.base.browser.SupportData
import kotlin.test.Test
import kotlin.test.assertEquals

class BrowserVersionVisitorTest {
    @Test
    fun `version calculated correctly`() {
        val rule = Rule("selector").apply {
            +Property(
                "p1",
                "v",
                SupportData(
                    chrome = 1.0,
                    firefox = 2.0,
                )
            )
            +Property(
                "p2",
                "v",
                SupportData(
                    chrome = 3.0,
                    firefox = 1.0,
                )
            )
        }

        val visitor = BrowserVersionVisitor()
        val result = visitor.visitRule(rule).result

        assertEquals(5, result.size)
        assertEquals(3.0, result["chrome"])
        assertEquals(2.0, result["firefox"])
        assertEquals(NOT_SUPPORTED, result["opera"])
        assertEquals(NOT_SUPPORTED, result["safari"])
        assertEquals(NOT_SUPPORTED, result["edge"])
    }

    @Test
    fun `version calculated correctly with missing browser`() {
        val rule = Rule("selector").apply {
            +Property(
                "p1",
                "v",
                SupportData(
                    chrome = 1.0,
                    firefox = 2.0,
                )
            )
            +Property(
                "p2",
                "v",
                SupportData(
                    chrome = 3.0
                )
            )
        }

        val visitor = BrowserVersionVisitor()
        val result = visitor.visitRule(rule).result

        assertEquals(5, result.size)
        assertEquals(3.0, result["chrome"])
        assertEquals(NOT_SUPPORTED, result["firefox"])
        assertEquals(NOT_SUPPORTED, result["opera"])
        assertEquals(NOT_SUPPORTED, result["safari"])
        assertEquals(NOT_SUPPORTED, result["edge"])
    }
}
