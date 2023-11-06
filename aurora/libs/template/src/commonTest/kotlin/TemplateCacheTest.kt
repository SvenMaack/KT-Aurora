package template_lib

import io.mockative.*
import template_lib.base.TagContainer
import template_lib.base.Visitor
import kotlin.test.Test

class TemplateCacheTest {
    @Mock
    val visitorMock = mock(classOf<Visitor<String>>())
    @Mock
    val staticTemplateMock = mock(classOf<Callable1R<Context, TagContainer>>())

    @Test
    fun `test cache works`() {
        val tag = TagContainer("parent")
        val context = Context({ visitorMock }, "1")
        every { staticTemplateMock.test(context) }.returns(tag)
        every { visitorMock.result }.returns("")

        TemplateCache.clear()

        TemplateCache.getOrSet(context, staticTemplateMock::test)
        TemplateCache.getOrSet(context, staticTemplateMock::test)

        verify { staticTemplateMock.test(context) }
            .wasInvoked(exactly = once)
    }
}