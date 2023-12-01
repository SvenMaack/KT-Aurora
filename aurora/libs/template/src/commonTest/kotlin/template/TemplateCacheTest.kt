package template

import io.mockative.*
import template.base.TagContainer
import template.base.HtmlVisitor
import template.base.HtmlVisitorStrategy
import kotlin.test.Test

class TemplateCacheTest {
    @Mock
    val htmlVisitorMock = mock(classOf<HtmlVisitor<String>>())
    @Mock
    val staticTemplateMock = mock(classOf<Fun2<Context, Unit, TagContainer>>())
    @Mock
    val htmlVisitorStrategyMock = mock(classOf<HtmlVisitorStrategy<String>>())
    @Mock
    val templateRendererMock = mock(classOf<ITemplateRenderer>())

    @Test
    fun `test cache works`() {
        val tag = TagContainer("parent")
        val context = Context(htmlVisitorStrategyMock, templateRendererMock)
        every { staticTemplateMock.invoke(context, Unit) }.returns(tag)
        every { htmlVisitorMock.result }.returns("")
        every { htmlVisitorStrategyMock.create() }.returns(htmlVisitorMock)
        every { templateRendererMock.render<Unit>(any(), any(), any()) }.returns("test")

        TemplateCache.clear()

        TemplateCache[context, staticTemplateMock::invoke]
        TemplateCache[context, staticTemplateMock::invoke]

        verify { templateRendererMock.render(context, staticTemplateMock::invoke, Unit) }
            .wasInvoked(exactly = once)
    }

    @Test
    fun `test clear works`() {
        val tag = TagContainer("parent")
        val context = Context(htmlVisitorStrategyMock, templateRendererMock)
        every { staticTemplateMock.invoke(context, Unit) }.returns(tag)
        every { htmlVisitorMock.result }.returns("")
        every { htmlVisitorStrategyMock.create() }.returns(htmlVisitorMock)
        every { templateRendererMock.render<Unit>(any(), any(), any()) }.returns("test")

        TemplateCache.clear()

        TemplateCache[context, staticTemplateMock::invoke]
        TemplateCache.clear()
        TemplateCache[context, staticTemplateMock::invoke]

        verify { templateRendererMock.render(context, staticTemplateMock::invoke, Unit) }
            .wasInvoked(exactly = twice)
    }
}
