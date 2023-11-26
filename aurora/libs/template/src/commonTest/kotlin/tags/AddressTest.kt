package template_lib.tags

import kotlin.test.Test
import kotlin.test.assertEquals

class AddressTest {
    @Test
    fun `tag name is abbr`() {
        val tag = Address()
        assertEquals("address", tag.name)
    }
}
