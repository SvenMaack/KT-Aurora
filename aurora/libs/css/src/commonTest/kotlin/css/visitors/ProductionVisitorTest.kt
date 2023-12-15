package css.visitors

import css.base.Document
import css.base.Property
import css.base.browser.SupportData
import kotlin.test.Test
import kotlin.test.assertEquals

class ProductionVisitorTest {
    @Test
    fun `visit rules turns them into string`() {
        val document = Document()
        document.apply {
            clazz["selector1"] = {
                +Property("property1", "value", SupportData(
                    chrome = 1.0,
                    firefox = 1.0,
                    safari = 1.0,
                    edge = 1.0,
                    opera = 1.0
                ))
            }
        }
        document.apply {
            clazz["selector2"] = {
                +Property("property2", "value", SupportData(
                    chrome = 1.0,
                    firefox = 1.0,
                    safari = 1.0,
                    edge = 1.0,
                    opera = 1.0
                ))
            }
        }
        val productionVisitor = ProductionVisitor()

        productionVisitor.visitRule(document.rules[0])
        productionVisitor.visitRule(document.rules[1])

        assertEquals(".selector1{property1:value;}.selector2{property2:value;}", productionVisitor.result)
    }
}
