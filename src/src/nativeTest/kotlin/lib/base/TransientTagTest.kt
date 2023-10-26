package lib.base

import io.mockative.*
import kotlin.test.Test

class TransientTagTest {
    @Mock
    val api = configure(mock(classOf<Visitor<String>>())) {
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
