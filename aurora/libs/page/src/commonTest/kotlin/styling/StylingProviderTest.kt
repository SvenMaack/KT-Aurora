package page_lib.styling

import css_lib.base.Document
import css_lib.base.Property
import page_lib.productionRuleVisitor
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals
import kotlin.test.assertSame

class StylingProviderTest {
    @Test
    fun `test not cache`() {
        val document = Document()
        val unCachedStyling = DefaultStyling(productionRuleVisitor, document)

        assertNotEquals(applyStylingAndGetOld(document, unCachedStyling), unCachedStyling.getCss())
    }

    @Test
    fun `test cache`() {
        val document = Document()
        val cachedStyling = CachedStyling(productionRuleVisitor, document)

        assertSame(applyStylingAndGetOld(document, cachedStyling), cachedStyling.getCss())
    }

    @Test
    fun `test empty styling`() {
        val emptyStyling = EmptyStyling

        assertEquals("", emptyStyling.getCss())
    }

    private fun applyStylingAndGetOld(document: Document, styling: Styling): String {
        document.apply {
            this["c1"] = {
                +Property.build("p", "v", "", listOf())
            }
        }
        val styling1 = styling.getCss()
        document.apply {
            this["c2"] = {
                +Property.build("p", "v", "", listOf())
            }
        }
        return styling1
    }
}
