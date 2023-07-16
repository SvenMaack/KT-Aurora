package lib.base

import io.mockative.configure
import io.mockative.Mock
import io.mockative.mock
import io.mockative.classOf
import io.mockative.verify
import io.mockative.time
import kotlin.test.Test
import kotlin.test.assertEquals

@Suppress("FunctionNaming")
class TagTest {
    @Mock
    val api = configure(mock(classOf<Visitor>())) {
        stubsUnitByDefault = true
    }

    @Test
    fun `tag is set correctly`() {
        assertEquals("p", Tag("p").tagName)
    }

    @Test
    fun `tag without content is set to empty`() {
        assertEquals("empty", Tag("").tagName)
    }

    @Test
    fun `tag is trimmed`() {
        assertEquals("p", Tag(" p").tagName)
        assertEquals("p", Tag("p ").tagName)
        assertEquals("p", Tag(" p ").tagName)
    }

    @Test
    fun `tag is alpha numeric`() {
        assertEquals("p", Tag("<§p>").tagName, )
        assertEquals("empty", Tag("<§>").tagName)
    }

    @Test
    fun `tag is lower string`() {
        assertEquals("p", Tag("P").tagName)
    }

    @Test
    fun `visitor is being called`() {
        val tag = Tag("a")
        tag.traverse(api)
        verify(api)
            .invocation {
                visitTag(tag)
            }
            .wasInvoked(exactly = 1.time)
    }
}