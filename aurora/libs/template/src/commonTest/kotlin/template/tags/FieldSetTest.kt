package template.tags

import kotlin.test.Test
import kotlin.test.assertEquals

class FieldSetTest {
    @Test
    fun `tag name is fieldSet`() {
        val fieldSet = Fieldset("id1")

        assertEquals("fieldset", fieldSet.name)
        assertEquals("id1", fieldSet.id)
    }
}
