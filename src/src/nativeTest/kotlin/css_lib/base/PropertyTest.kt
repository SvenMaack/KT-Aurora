package css_lib.base

import kotlin.test.Test
import kotlin.test.assertEquals

class PropertyTest {
    @Test
    fun `test property is rendered correctly`() {
        val property = UnsupportedProperty("value", "property")

        assertEquals("value:property;", property.toString())
    }
}
