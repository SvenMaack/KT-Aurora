package template.tags

import kotlin.test.Test
import kotlin.test.assertEquals

class HeaderTest {
    @Test
    fun `tag name is h1`() {
        val tag = H1()

        assertEquals("h1", tag.name)
    }

    @Test
    fun `tag name is h2`() {
        val tag = H2()

        assertEquals("h2", tag.name)
    }

    @Test
    fun `tag name is h3`() {
        val tag = H3()

        assertEquals("h3", tag.name)
    }

    @Test
    fun `tag name is h4`() {
        val tag = H4()

        assertEquals("h4", tag.name)
    }

    @Test
    fun `tag name is h5`() {
        val tag = H5()

        assertEquals("h5", tag.name)
    }

    @Test
    fun `tag name is h6`() {
        val tag = H6()

        assertEquals("h6", tag.name)
    }

    @Test
    fun `tag name is header`() {
        val tag = Header()

        assertEquals("header", tag.name)
    }
}
