package template_lib

import io.mockative.*
import template_lib.base.TagContainer
import template_lib.base.HtmlVisitor
import template_lib.base.HtmlVisitorStrategy
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
        val context = Context(htmlVisitorStrategyMock, templateRendererMock)
        val vm = "test1"
        every { htmlVisitorStrategyMock.create() }.returns(htmlVisitorMock)
        every { htmlVisitorMock.result }.returns("visitorResult")
        every { dynamicTemplateMock.invoke(context, vm) }.returns(tag)

        val result = TemplateRenderer().render(context, dynamicTemplateMock::invoke, vm)
        assertEquals("visitorResult", result)
    }

    @Test
    fun `test dynamic template render works for static template`() {
        val tag = TagContainer("parent")
        val context = Context(htmlVisitorStrategyMock, templateRendererMock)
        every { htmlVisitorStrategyMock.create() }.returns(htmlVisitorMock)
        every { htmlVisitorMock.result }.returns("visitorResult")
        every { staticTemplateMock.invoke(context, Unit) }.returns(tag)

        val result = TemplateRenderer().render(context, staticTemplateMock::invoke)
        assertEquals("visitorResult", result)
    }

    @Test
    fun `test dynamic template render works for element`() {
        val tag = TagContainer("parent")
        val context = Context(htmlVisitorStrategyMock, templateRendererMock)
        every { htmlVisitorMock.result }.returns("visitorResult")
        every { htmlVisitorStrategyMock.create() }.returns(htmlVisitorMock)

        val result = TemplateRenderer().render(context, tag)
        assertEquals("visitorResult", result)
    }
}
