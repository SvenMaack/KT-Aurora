package page_lib.runtimeDecorators

import css_lib.base.Document
import css_lib.base.Property
import css_lib.base.browser.Chrome
import io.mockative.*
import page_lib.IPage
import template_lib.CSS
import template_lib.Context
import template_lib.base.TagContainer
import template_lib.base.Visitor
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class BrowserSupportPageDecoratorTest {
    @Mock
    val page = mock(classOf<IPage>())
    @Mock
    val visitor = mock(classOf<Visitor<String>>())
    private val context = getContext()
    private val support = Chrome { 3.14 }

    @BeforeTest
    fun init() {
        every { page.internalDocument }.returns(Document())
        every { page.externalDocument }.returns(Document().apply {
            this["c"] = {
                +Property.build("p","v", supportedBrowsers=listOf(support))
            }
        })
        every { page.getHtml(any(), any()) }.returns("")
    }

    @Test
    fun `inner page is called`() {
        val tag = TagContainer("test")
        val browserSupportPageDecorator = BrowserSupportPageDecorator(page)

        browserSupportPageDecorator.getHtml(context, tag)

        verify { page.getHtml(context, tag) }
            .wasInvoked(exactly = once)
    }

    @Test
    fun `tag is populated with Versions`() {
        val tag = TagContainer("test")
        val browserSupportPageDecorator = BrowserSupportPageDecorator(page)

        browserSupportPageDecorator.getHtml(context, tag)

        assertEquals(mapOf(support.browserName to listOf("3.14")), tag.attributes)
    }

    private fun getContext(): Context =
        Context(
            { visitor },
            CSS("", "")
        )
}
