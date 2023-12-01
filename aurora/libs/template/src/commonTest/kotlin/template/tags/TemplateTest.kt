package template.tags

import kotlin.test.Test
import kotlin.test.assertEquals

class TemplateTest {
    @Test
    fun `tag name is template`() {
        val tag = Template()

        assertEquals("template", tag.name)
    }
}
