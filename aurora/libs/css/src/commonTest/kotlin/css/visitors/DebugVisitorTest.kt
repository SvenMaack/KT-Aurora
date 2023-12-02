package css.visitors

import css.base.Document
import css.base.Property
import kotlin.test.Test
import kotlin.test.assertEquals

class DebugVisitorTest {
    @Test
    fun `visit rules turns them into string`() {
        val document = Document()
        document["selector"] = {
            +Property.build("property", "value")
        }
        val debugVisitor = DebugVisitor()

        debugVisitor.visitRule(document.rules[0])

        assertEquals(".selector {${DebugVisitor.LINE_BREAK}${DebugVisitor.INDENTATION}property:value;${DebugVisitor.LINE_BREAK}}${DebugVisitor.LINE_BREAK}", debugVisitor.result)
    }
}
