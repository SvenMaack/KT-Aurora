package template.tags

import io.mockative.*
import kotlin.test.Test
import kotlin.test.assertEquals

class FieldSetTest {
    @Mock
    val blockLegend = mock(classOf<Fun1<Legend, Unit>>())

    @Test
    fun `tag name is fieldSet`() {
        val fieldSet = Fieldset("id1")

        assertEquals("fieldset", fieldSet.name)
        assertEquals("id1", fieldSet.id)
    }

    @Test
    fun `legend function works`() {
        val fieldset = Fieldset("id1")
        every { blockLegend.invoke(any()) }.returns(Unit)

        val legend = fieldset.legend(blockLegend::invoke)

        verify { blockLegend.invoke(legend) }
            .wasInvoked(exactly = once)

    }
}
