package page_lib.runtimeDecorators

import css_lib.base.Document
import css_lib.base.RuleVisitor
import io.mockative.*
import page_lib.IPage
import kotlin.test.BeforeTest
import kotlin.test.Test

class StylingCachePageDecoratorTest {
    @Mock
    val page = mock(classOf<IPage>())
    @Mock
    val ruleVisitor = mock(classOf<RuleVisitor<String>>())

    @BeforeTest
    fun init() {
        every { page.internalDocument }.returns(Document())
        every { page.externalDocument }.returns(Document())
        every { page.getInternalCss(any()) }.returns("")
        every { page.getExternalCss(any()) }.returns("")
    }

    @Test
    fun `internal styling is cached`() {
        val stylingCachePageDecorator = StylingCachePageDecorator(page, {ruleVisitor})

        stylingCachePageDecorator.getInternalCss({ruleVisitor})
        stylingCachePageDecorator.getInternalCss({ruleVisitor})

        verify { page.getInternalCss(any()) }
            .wasInvoked(exactly = once)
    }

    @Test
    fun `external styling is cached`() {
        val stylingCachePageDecorator = StylingCachePageDecorator(page, {ruleVisitor})

        stylingCachePageDecorator.getExternalCss({ruleVisitor})
        stylingCachePageDecorator.getExternalCss({ruleVisitor})

        verify { page.getExternalCss(any()) }
            .wasInvoked(exactly = once)
    }
}
