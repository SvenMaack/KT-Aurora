package css_lib.base

import Callable
import io.mockative.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertSame

class RuleTest {
    @Mock
    val ruleMock = mock(classOf<Callable<Rule>>())

    @Test
    fun `test rule creation works`() {
        val rule: Rule = "selector".rule(ruleMock::test)

        assertEquals("selector", rule.classSelector)
        verify { ruleMock.test(rule) }
            .wasInvoked(exactly = once)
    }

    @Test
    fun `test rule get class works`() {
        val rule: Rule = "selector".rule(ruleMock::test)

        assertEquals("selector", rule.getClass())
    }

    @Test
    fun `test add property works`() {
        val property = Property.build("a", "b")
        val rule: Rule = "selector".rule {
            +property
        }

        assertEquals(1, rule.properties.size)
        assertSame(property, rule.properties[0])
    }
}
