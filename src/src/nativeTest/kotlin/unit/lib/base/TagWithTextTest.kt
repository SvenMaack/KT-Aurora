package unit.lib.base

import io.mockative.configure
import io.mockative.Mock
import io.mockative.mock
import io.mockative.classOf
import io.mockative.verify
import io.mockative.time
import lib.base.TagWithText
import lib.base.TextElement
import lib.base.Visitor
import kotlin.test.Test
import kotlin.test.assertEquals

class TagWithTextTest {
    @Mock
    val api = configure(mock(classOf<Visitor<String>>())) {
        stubsUnitByDefault = true
    }

    @Test
    fun `text is saved correctly`() {
        val tag = TagWithText("p")
        with(tag) {
            +"Lorem"
        }
        assertEquals("Lorem", (tag.children.first() as TextElement).text)
    }

    @Test
    fun `adding text adds a child`() {
        val tag = TagWithText("p")
        assertEquals(0, tag.children.size)
        with(tag) {
            +"Lorem"
        }
        assertEquals(1, tag.children.size)
    }

    @Test
    fun `visitor is being called`() {
        val tag = TagWithText("p")
        val tx: TextElement?
        with(tag) {
            tx = +"Lorem"
        }

        tag.traverse(api)

        verify(api)
            .invocation {
                visitTextElement(tx!!)
            }
            .wasInvoked(exactly = 1.time)
    }
}
