package template

import io.mockative.*
import template.base.TagContainer
import template.base.HtmlVisitor
import template.base.HtmlVisitorStrategy
import template.tags.enums.CountryCode
import template.tags.enums.GeneralLanguage
import template.tags.enums.minus
import kotlin.test.Test
import kotlin.test.assertEquals

class TemplateRendererTest {
    @Mock
    val htmlVisitorMock = mock(classOf<HtmlVisitor<String>>())
    @Mock
    val dynamicTemplateMock = mock(classOf<Fun2<Context, String, TagContainer>>())
    @Mock
    val staticTemplateMock = mock(classOf<Fun2<Context, Unit, TagContainer>>())
    @Mock
    val htmlVisitorStrategyMock = mock(classOf<HtmlVisitorStrategy<String>>())
    @Mock
    val templateRendererMock = mock(classOf<ITemplateRenderer>())

    @Test
    fun `test dynamic template render works`() {
        val tag = TagContainer("parent")
        val context = Context(templateRenderer = templateRendererMock, language = GeneralLanguage.English, country = CountryCode.UNITED_STATES)
        val vm = "test1"
        every { htmlVisitorStrategyMock.create() }.returns(htmlVisitorMock)
        every { htmlVisitorMock.result }.returns("visitorResult")
        every { dynamicTemplateMock.invoke(context, vm) }.returns(tag)

        val result = TemplateRenderer(htmlVisitorStrategyMock).render(context, dynamicTemplateMock::invoke, vm)
        assertEquals("visitorResult", result)
    }

    @Test
    fun `test dynamic template render works for static template`() {
        val tag = TagContainer("parent")
        val context = Context(templateRenderer = templateRendererMock, language = GeneralLanguage.English, country = CountryCode.UNITED_STATES)
        every { htmlVisitorStrategyMock.create() }.returns(htmlVisitorMock)
        every { htmlVisitorMock.result }.returns("visitorResult")
        every { staticTemplateMock.invoke(context, Unit) }.returns(tag)

        val result = TemplateRenderer(htmlVisitorStrategyMock).render(context, staticTemplateMock::invoke)
        assertEquals("visitorResult", result)
    }

    @Test
    fun `test dynamic template render works for element`() {
        val tag = TagContainer("parent")
        val context = Context(templateRenderer = templateRendererMock, language = GeneralLanguage.English, country = CountryCode.UNITED_STATES)
        every { htmlVisitorMock.result }.returns("visitorResult")
        every { htmlVisitorStrategyMock.create() }.returns(htmlVisitorMock)

        val result = TemplateRenderer(htmlVisitorStrategyMock).render(context, tag)
        assertEquals("visitorResult", result)
    }
}
