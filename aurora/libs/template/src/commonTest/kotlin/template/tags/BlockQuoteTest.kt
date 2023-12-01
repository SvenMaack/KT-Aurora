package template.tags

import kotlin.test.Test
import kotlin.test.assertEquals

class BlockQuoteTest {
    @Test
    fun `tag name is blockquote`() {
        val tag = BlockQuote()

        assertEquals("blockquote", tag.name)
    }
}
