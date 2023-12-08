package css.visitors

import css.base.Document
import css.base.Property
import css.base.browser.SupportData
import kotlin.test.Test
import kotlin.test.assertEquals

class DebugVisitorTest {
    @Test
    fun `visit rules turns them into string`() {
        val document = Document()
        document["selector"] = {
            +Property("property", "value", SupportData(
                chrome = 1.0,
                firefox = 1.0,
                safari = 1.0,
                edge = 1.0,
                opera = 1.0
            ))
        }
        val debugVisitor = DebugVisitor()

        debugVisitor.visitRule(document.rules[0])

        assertEquals(".selector {${DebugVisitor.LINE_BREAK}${DebugVisitor.INDENTATION}/* chrome: 1.0, firefox: 1.0, safari: 1.0, edge: 1.0, opera: 1.0 */${DebugVisitor.LINE_BREAK}${DebugVisitor.INDENTATION}property:value;${DebugVisitor.LINE_BREAK}}${DebugVisitor.LINE_BREAK}", debugVisitor.result)
    }
}
