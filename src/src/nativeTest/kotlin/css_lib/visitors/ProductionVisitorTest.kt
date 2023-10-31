package css_lib.visitors

import css_lib.base.Document
import css_lib.base.Property
import css_lib.base.UnsupportedProperty
import kotlin.test.Test
import kotlin.test.assertEquals

class ProductionVisitorTest {
    @Test
    fun `visit rules turns them into string`() {
        val document = Document()
        document["selector1"] = {
            +UnsupportedProperty("property1", "value")
        }
        document["selector2"] = {
            +UnsupportedProperty("property2", "value")
        }
        val productionVisitor = ProductionVisitor()

        productionVisitor.visitRule(document.rules[0])
        productionVisitor.visitRule(document.rules[1])

        assertEquals("selector1{property1:value;}selector2{property2:value;}", productionVisitor.result)
    }
}
