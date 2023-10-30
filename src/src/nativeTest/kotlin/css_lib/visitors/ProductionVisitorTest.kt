package css_lib.visitors

import css_lib.base.Document
import css_lib.base.Property
import kotlin.test.Test
import kotlin.test.assertEquals

class ProductionVisitorTest {
    @Test
    fun `visit rules turns them into string`() {
        val document = Document()
        document["selector"] = {
            add(Property("property", "value"))
        }
        val productionVisitor = ProductionVisitor()

        productionVisitor.visitRule(document.rules[0])

        assertEquals("selector{property:value;}", productionVisitor.result)
    }
}
