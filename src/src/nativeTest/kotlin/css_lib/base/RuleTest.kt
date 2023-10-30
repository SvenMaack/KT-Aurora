package css_lib.base

import css_lib.base.Property
import css_lib.base.Rule
import css_lib.base.rule
import io.mockative.*
import template_lib.tags.Callable
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertSame

class RuleTest {
    @Mock
    val ruleMock = mock(classOf<Callable<Rule>>())

    @Test
    fun `test rule creation works`() {
        val rule: Rule = "selector".rule(ruleMock::test)

        assertEquals("selector", rule.selector)
        verify { ruleMock.test(rule) }
            .wasInvoked(exactly = once)
    }

    @Test
    fun `test add property works`() {
        val property = Property("a", "b")
        val rule: Rule = "selector".rule {
            add(property)
        }

        assertEquals(1, rule.properties.size)
        assertSame(property, rule.properties[0])
    }
}