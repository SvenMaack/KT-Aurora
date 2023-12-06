package template

import io.mockative.*
import template.base.TagContainer
import template.base.HtmlVisitorStrategy
import kotlin.test.Test

class TemplateCompositionTest {
    @Mock
    val htmlVisitorStrategyMock = mock(classOf<HtmlVisitorStrategy<String>>())
    @Mock
    val templateRendererMock = mock(classOf<ITemplateRenderer>())
    @Mock
    val templateExtensionMock = mock(classOf<Fun3<TagContainer, Context, String, Unit>>())
    @Mock
    val staticTemplateExtensionMock = mock(classOf<Fun3<TagContainer, Context, Unit, Unit>>())

    @Test
    fun `include template works`() {
        val parent = TagContainer("parent")
        val context = Context(htmlVisitorStrategyMock, templateRendererMock)
        val vm = "vm"
        every { templateExtensionMock.invoke(parent, context, vm) }.returns(Unit)

        parent.apply {
            include(context=context, template=templateExtensionMock::invoke, vm=vm)
        }

        verify { templateExtensionMock.invoke(parent, context, vm) }
            .wasInvoked(exactly = once)
    }

    @Test
    fun `include static template works`() {
        val parent = TagContainer("parent")
        val context = Context(htmlVisitorStrategyMock, templateRendererMock)
        every { staticTemplateExtensionMock.invoke(parent, context, Unit) }.returns(Unit)

        parent.apply {
            include(context=context, template=staticTemplateExtensionMock::invoke)
        }

        verify { staticTemplateExtensionMock.invoke(parent, context, Unit) }
            .wasInvoked(exactly = once)
    }
}
