package css.base

import kotlin.test.Test
import kotlin.test.assertEquals

class SelectorTest {
    @Test
    fun `class works`() {
        val selector = Class("c1")

        assertEquals("c1", selector.name)
        assertEquals(".c1", selector.toString())
        assertEquals(SelectorType.CLASS, selector.getType())
    }


    @Test
    fun `invalid characters are removed from class`() {
        val selector = Class("c1 +>~.,")

        assertEquals("c1 +>~.,", selector.name)
        assertEquals(".c1", selector.toString())
        assertEquals(SelectorType.CLASS, selector.getType())
    }

    @Test
    fun `universal works`() {
        val selector = UNIVERSAL

        assertEquals("*", selector.toString())
        assertEquals(SelectorType.UNIVERSAL, selector.getType())
    }

    @Test
    fun `id works`() {
        val selector = Id("i1")

        assertEquals("i1", selector.name)
        assertEquals("#i1", selector.toString())
        assertEquals(SelectorType.ID, selector.getType())
    }

    @Test
    fun `invalid characters are removed from id`() {
        val selector = Id("i1 +>~.,")

        assertEquals("i1 +>~.,", selector.name)
        assertEquals("#i1", selector.toString())
        assertEquals(SelectorType.ID, selector.getType())
    }

    @Test
    fun `tag works`() {
        val selector = Tag("t1")

        assertEquals("t1", selector.name)
        assertEquals("t1", selector.toString())
        assertEquals(SelectorType.TAG, selector.getType())
    }

    @Test
    fun `pseudo works`() {
        val selector = Tag("t1")
        val pseudo = Pseudo(selector, PseudoValues.AFTER)

        assertEquals("t1:after", pseudo.toString())
        assertEquals(SelectorType.PSEUDO, pseudo.getType())
    }

    @Test
    fun `invalid characters are removed from tag`() {
        val selector = Tag("t1 +>~.,")

        assertEquals("t1 +>~.,", selector.name)
        assertEquals("t1", selector.toString())
        assertEquals(SelectorType.TAG, selector.getType())
    }
}
