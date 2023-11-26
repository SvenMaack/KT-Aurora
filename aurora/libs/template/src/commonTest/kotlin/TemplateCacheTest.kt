package template_lib

import io.mockative.*
import template_lib.base.TagContainer
import template_lib.base.HtmlVisitor
import kotlin.test.Test

class TemplateCacheTest {
    @Mock
    val htmlVisitorMock = mock(classOf<HtmlVisitor<String>>())
    @Mock
    val staticTemplateMock = mock(classOf<Callable1R<Context, TagContainer>>())

    @Test
    fun `test cache works`() {
        val tag = TagContainer("parent")
        val context = Context({ htmlVisitorMock }, CSS())
        every { staticTemplateMock.test(context) }.returns(tag)
        every { htmlVisitorMock.result }.returns("")

        TemplateCache.clear()

        TemplateCache.getOrSet(context, staticTemplateMock::test)
        TemplateCache.getOrSet(context, staticTemplateMock::test)

        verify { staticTemplateMock.test(context) }
            .wasInvoked(exactly = once)
    }
}