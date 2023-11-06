package template_lib

import io.mockative.Mock
import io.mockative.classOf
import io.mockative.every
import io.mockative.mock
import template_lib.base.TagContainer
import template_lib.base.Visitor
import kotlin.test.Test
import kotlin.test.assertEquals

class TemplateRendererTest {
    @Mock
    val visitorMock = mock(classOf<Visitor<String>>())
    @Mock
    val dynamicTemplateMock = mock(classOf<Callable2R<Context, String, TagContainer>>())
    @Mock
    val staticTemplateMock = mock(classOf<Callable1R<Context, TagContainer>>())

    @Test
    fun `test dynamic template render works`() {
        val tag = TagContainer("parent")
        val context = Context({ visitorMock },"1")
        val dto = "test1"
        every { dynamicTemplateMock.test(context, dto) }.returns(tag)
        every { visitorMock.result }.returns("visitorResult")

        val result = TemplateRenderer.render(context, dynamicTemplateMock::test, dto)
        assertEquals("visitorResult", result)
    }

    @Test
    fun `test static template render works`() {
        val tag = TagContainer("parent")
        val context = Context({ visitorMock },"1")
        every { staticTemplateMock.test(context) }.returns(tag)
        every { visitorMock.result }.returns("visitorResult")

        val result = TemplateRenderer.render(context, staticTemplateMock::test)
        assertEquals("visitorResult", result)
    }
}