package css.base

import kotlin.test.Test
import kotlin.test.assertEquals

class SelectorTest {
    @Test
    fun `class works`() {
        val selector = Class("c1")

        assertEquals("c1", selector.name)
        assertEquals(".c1", selector.asString())
        assertEquals(SelectorType.CLASS, selector.getType())
    }

    @Test
    fun `invalid characters are removed from class`() {
        val selector = Class("c1 +>~.,")

        assertEquals("c1 +>~.,", selector.name)
        assertEquals(".c1", selector.asString())
        assertEquals(SelectorType.CLASS, selector.getType())
    }

    @Test
    fun `id works`() {
        val selector = Id("i1")

        assertEquals("i1", selector.name)
        assertEquals("#i1", selector.asString())
        assertEquals(SelectorType.ID, selector.getType())
    }

    @Test
    fun `invalid characters are removed from id`() {
        val selector = Id("i1 +>~.,")

        assertEquals("i1 +>~.,", selector.name)
        assertEquals("#i1", selector.asString())
        assertEquals(SelectorType.ID, selector.getType())
    }

    @Test
    fun `tag works`() {
        val selector = Tag("t1")

        assertEquals("t1", selector.name)
        assertEquals("t1", selector.asString())
        assertEquals(SelectorType.TAG, selector.getType())
    }

    @Test
    fun `invalid characters are removed from tag`() {
        val selector = Tag("t1 +>~.,")

        assertEquals("t1 +>~.,", selector.name)
        assertEquals("t1", selector.asString())
        assertEquals(SelectorType.TAG, selector.getType())
    }
}
