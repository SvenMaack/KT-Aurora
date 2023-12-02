package css.base

import css.base.browser.Chrome
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertSame

class PropertyTest {
    @Test
    fun `test builder`() {
        val browserSupport = listOf(Chrome { 1.0 })
        val property = Property.build("property", "value", "a", browserSupport)

        assertEquals("property", property.property)
        assertEquals("value", property.value)
        assertEquals("a", property.defaultValue)
        assertSame(browserSupport, property.supportedBrowsers)
    }

    @Test
    fun `test property is rendered correctly`() {
        val property = Property.build("property", "value")

        assertEquals("property:value;", property.toString())
    }
}
