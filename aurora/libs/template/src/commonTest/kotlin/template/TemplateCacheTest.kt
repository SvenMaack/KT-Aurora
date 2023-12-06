package template

import io.mockative.*
import template.tags.Div
import template.tags.enums.CountryCode
import template.tags.enums.GeneralLanguage
import template.tags.enums.minus
import kotlin.test.Test

class TemplateCacheTest {
    @Mock
    val templateRendererMock = mock(classOf<ITemplateRenderer>())
    @Mock
    val staticTemplateExtensionMock = mock(classOf<Fun3<Div, Context, Unit, Unit>>())

    @Test
    fun `test cache object works`() {
        val context = Context(templateRenderer = templateRendererMock, language = GeneralLanguage.English - CountryCode.UNITED_STATES)
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
        val context = Context(templateRenderer = templateRendererMock, language = GeneralLanguage.English - CountryCode.UNITED_STATES)
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
