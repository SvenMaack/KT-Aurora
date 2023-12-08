package css

import css.base.Class
import css.base.Document
import css.base.Property
import css.base.RuleVisitor
import css.base.RuleVisitorFactory
import css.visitors.ProductionVisitor
import io.mockative.*
import kotlin.test.Test

class CssRendererTest {
    @Mock
    val visitorFactory = mock(classOf<RuleVisitorFactory<String>>())
    @Mock
    val visitor = mock(classOf<RuleVisitor<String>>())

    @Test
    fun `test rendering uses factory`() {
        every { visitorFactory.create() }.returns(ProductionVisitor())

        CssRenderer.render(visitorFactory, Document())

        verify { visitorFactory.create() }
            .wasInvoked(exactly = once)
    }

    @Test
    fun `test rendering traverses rules`() {
        every { visitor.visitRule(any()) }.returns(visitor)
        every { visitor.result }.returns("")

        CssRenderer.render(
            { visitor },
            Document().apply {
                this[Class("class")] = {
                    +Property(
                        property = "property",
                        value = "value",
                        supportedBrowsers = listOf()
                    )
                }
            }
        )

        verify { visitor.visitRule(any()) }
            .wasInvoked(exactly = once)
    }
}