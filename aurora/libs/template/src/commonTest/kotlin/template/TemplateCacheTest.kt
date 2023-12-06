package template

import io.mockative.*
import template.base.HtmlVisitorStrategy
import template.tags.Div
import kotlin.test.Test

class TemplateCacheTest {
    @Mock
    val htmlVisitorStrategyMock = mock(classOf<HtmlVisitorStrategy<String>>())
    @Mock
    val templateRendererMock = mock(classOf<ITemplateRenderer>())
    @Mock
    val staticTemplateExtensionMock = mock(classOf<Fun3<Div, Context, Unit, Unit>>())

    @Test
    fun `test cache object works`() {
        val context = Context(htmlVisitorStrategyMock, templateRendererMock)
        every { templateRendererMock.render(context = any(), element = any()) }.returns("test")
        every { staticTemplateExtensionMock.invoke(any(), any(), any())}.returns(Unit)

        TemplateCache.clear()

        TemplateCache[context, staticTemplateExtensionMock::invoke, ::Div]
        TemplateCache[context, staticTemplateExtensionMock::invoke, ::Div]

        verify { staticTemplateExtensionMock.invoke(any(), any(), any()) }
            .wasInvoked(exactly = once)
    }

    @Test
    fun `test cache function works`() {
        val parent = Div()
        val context = Context(htmlVisitorStrategyMock, templateRendererMock)
        every { templateRendererMock.render(context = any(), element = any()) }.returns("test")
        every { staticTemplateExtensionMock.invoke(any(), any(), any())}.returns(Unit)

        TemplateCache.clear()

        parent.apply {
            cache(context = context, template = staticTemplateExtensionMock::invoke, ref = ::Div)
            cache(context = context, template = staticTemplateExtensionMock::invoke, ref = ::Div)
        }

        verify { staticTemplateExtensionMock.invoke(any(), any(), any()) }
            .wasInvoked(exactly = once)
    }
}
