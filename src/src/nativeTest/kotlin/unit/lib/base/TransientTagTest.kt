package unit.lib.base

import io.mockative.*
import lib.base.TransientTag
import lib.base.Visitor
import kotlin.test.Test

class TransientTagTest {
    @Mock
    val api = configure(mock(classOf<Visitor>())) {
        stubsUnitByDefault = true
    }

    @Test
    fun `visitor is not called`() {
        val tag = TransientTag()
        tag.traverse(api)
        verify(api)
            .invocation {
                visitTag(tag)
                visitTagContainerBegin(tag)
                visitTagContainerEnd(tag)
            }
            .wasNotInvoked()
    }
}
