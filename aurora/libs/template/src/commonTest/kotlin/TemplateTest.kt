package template_lib

import io.mockative.*
import template_lib.base.Tag
import template_lib.base.TagContainer
import template_lib.base.HtmlVisitor
import template_lib.base.HtmlVisitorStrategy
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals
import kotlin.test.assertSame

class TemplateTest {
    @Mock
    val htmlVisitorMock = mock(classOf<HtmlVisitor<String>>())
    @Mock
    val htmlVisitorStrategyMock = mock(classOf<HtmlVisitorStrategy<String>>())
    @Mock
    val templateRendererMock = mock(classOf<ITemplateRenderer>())
    @Mock
    val dynamicTemplateMock = mock(classOf<Fun2<Context, String, TagContainer>>())
    @Mock
    val staticTemplateMock = mock(classOf<Fun2<Context, Unit, TagContainer>>())


    @Test
    fun `include template adds children`() {
        val child = TagContainer("child")
        val parent = TagContainer("parent")
        val context = Context(htmlVisitorStrategyMock, templateRendererMock)
        val template: Template<String> = { _, _ ->
            child
        }

        parent.apply {
            include(context=context, template=template, vm="child")
        }

        assertEquals(1, parent.children.size)
        assertSame(child, parent.children[0])
    }

    @Test
    fun `include template calls template function`() {
        val tag = TagContainer("parent")
        val vm = "child"
        val context = Context(htmlVisitorStrategyMock, templateRendererMock)
        every { dynamicTemplateMock.invoke(context, vm) }.returns(tag)

        tag.apply {
            include(context=context, template=dynamicTemplateMock::invoke, vm=vm)
        }

        verify { dynamicTemplateMock.invoke(context, vm) }
            .wasInvoked(exactly = once)
    }

    @Test
    fun `include static template several times calls static template function only once`() {
        val tag = TagContainer("parent")
        val context = Context(htmlVisitorStrategyMock, templateRendererMock)
        every { staticTemplateMock.invoke(context, Unit) }.returns(tag)
        every { htmlVisitorMock.result }.returns("")
        every { templateRendererMock.render<Unit>(any(), any(), any()) }.returns("test")

        tag.apply {
            include(context=context, template=staticTemplateMock::invoke)
            include(context=context, template=staticTemplateMock::invoke)
        }

        verify { templateRendererMock.render(context, staticTemplateMock::invoke, Unit) }
            .wasInvoked(exactly = once)
    }

    @Test
    fun `include static template several times calls static template function only once with equal context`() {
        val tag = TagContainer("parent")
        every { staticTemplateMock.invoke(any(), any()) }.returns(tag)
        every { htmlVisitorMock.result }.returns("")
        every { templateRendererMock.render<Unit>(any(), any(), any()) }.returns("test")

        tag.apply {
            include(context=Context(htmlVisitorStrategyMock, templateRendererMock), template=staticTemplateMock::invoke)
            include(context=Context(htmlVisitorStrategyMock, templateRendererMock), template=staticTemplateMock::invoke)
        }

        verify { templateRendererMock.render<Unit>(any(), any(), any()) }
            .wasInvoked(exactly = once)
    }

    @Test
    fun `test childs function of tagContainer`() {
        val parent = TagContainer("parent")
        val child = Tag("child")
        parent.apply {
            add(child)
        }
        val toTest = parent.childs()

        assertNotEquals(toTest, parent)
        assertEquals(1, toTest.children.size)
        assertSame(child, toTest.children[0])
    }
}
