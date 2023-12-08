package css.base

import css.base.browser.SupportData
import css.base.browser.SupportDataOverride
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertSame

class PropertyTest {
    @Test
    fun `test builder`() {
        val property = Property(
            property = "property",
            value = "value",
            supportedBrowsers = SupportData(chrome = 1.0)
        )

        assertEquals("property", property.property)
        assertEquals("value", property.value)
        assertEquals(SupportData(chrome = 1.0), property.supportedBrowsers)
    }

    @Test
    fun `test property is rendered correctly`() {
        val property = Property("property", "value", SupportData())

        assertEquals("property:value;", property.toString())
    }

    @Test
    fun `test moz prefix works`() {
        val property = Property("property", "value", SupportData())
        val prefixedProperty = property.moz(SupportDataOverride(chrome = 42.0))

        assertEquals("-moz-property:value;property:value;", prefixedProperty.toString())
        assertEquals(42.0, prefixedProperty.supportedBrowsers.chrome)
    }

    @Test
    fun `test webkit prefix works`() {
        val property = Property("property", "value", SupportData())
        val prefixedProperty = property.webkit(SupportDataOverride(chrome = 42.0))

        assertEquals("-webkit-property:value;property:value;", prefixedProperty.toString())
        assertEquals(42.0, prefixedProperty.supportedBrowsers.chrome)
    }
}
