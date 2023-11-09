package base

import css_lib.base.Document
import css_lib.base.Property
import css_lib.base.RuleVisitor
import css_lib.base.RuleVisitorFactory
import css_lib.visitors.ProductionVisitor
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
                this["class"] = {
                    +Property.build(
                        property = "property",
                        value = "value",
                        defaultValue = "0",
                        supportedBrowsers = listOf()
                    )
                }
            }
        )

        verify { visitor.visitRule(any()) }
            .wasInvoked(exactly = once)
    }
}