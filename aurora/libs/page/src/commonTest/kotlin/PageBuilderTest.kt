package page_lib

import css_lib.base.Document
import css_lib.base.RuleVisitorFactory
import kotlin.test.Test
import kotlin.test.assertEquals

class PageBuilderTest {
    @Test
    fun `every decorator is called`() {
        var identityDecorator1: IdentityDecorator? = null
        var identityDecorator2: IdentityDecorator? = null
        val pageFacade = PageBuilder(
            "test",
            Document(),
            runtimeModifier = { page: IPage ->
                IdentityDecorator(page).apply {
                    identityDecorator1 = this
                }
            }+{ page ->
                IdentityDecorator(page).apply {
                    identityDecorator2 = this
                }
            }
        ).build()

        pageFacade.getExternalCss()
        pageFacade.getExternalCss()

        assertEquals(2, identityDecorator1?.counter)
        assertEquals(2, identityDecorator2?.counter)
    }

    @Test
    fun `test cache at beginning caches decorator after`() {
        var identityDecorator1: IdentityDecorator? = null
        var identityDecorator2: IdentityDecorator? = null
        val pageFacade = PageBuilder(
            "test",
            Document(),
            runtimeModifier = StylingCache+{ page ->
                IdentityDecorator(page).apply {
                    identityDecorator1 = this
                }
             }+{ page ->
                IdentityDecorator(page).apply {
                    identityDecorator2 = this
                }
            }
        ).build()

        pageFacade.getExternalCss()
        pageFacade.getExternalCss()

        assertEquals(1, identityDecorator1?.counter)
        assertEquals(1, identityDecorator2?.counter)
    }

    @Test
    fun `test cache at end doesn't cache decorator before`() {
        var identityDecorator1: IdentityDecorator? = null
        var identityDecorator2: IdentityDecorator? = null
        val pageFacade = PageBuilder(
            "test",
            Document(),
            runtimeModifier = { page: IPage ->
                IdentityDecorator(page).apply {
                    identityDecorator1 = this
                }
            }+{ page ->
                IdentityDecorator(page).apply {
                    identityDecorator2 = this
                }
            }+StylingCache
        ).build()

        pageFacade.getExternalCss()
        pageFacade.getExternalCss()

        assertEquals(2, identityDecorator1?.counter)
        assertEquals(2, identityDecorator2?.counter)
    }
}

private class IdentityDecorator(private val inner: IPage): IPage by inner {
    var counter = 0
    override fun getExternalCss(ruleVisitorFactory: RuleVisitorFactory<String>): String {
        ++counter
        return inner.getExternalCss(ruleVisitorFactory)
    }
}
