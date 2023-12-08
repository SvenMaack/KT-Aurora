package css.base

import css.base.browser.Chrome
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertSame

class PropertyTest {
    @Test
    fun `test builder`() {
        val browserSupport = listOf(Chrome { 1.0 })
        val property = Property(
            property = "property",
            value = "value",
            supportedBrowsers = browserSupport
        )

        assertEquals("property", property.property)
        assertEquals("value", property.value)
        assertSame(browserSupport, property.supportedBrowsers)
    }

    @Test
    fun `test property is rendered correctly`() {
        val property = Property("property", "value", listOf())

        assertEquals("property:value;", property.toString())
    }
}
