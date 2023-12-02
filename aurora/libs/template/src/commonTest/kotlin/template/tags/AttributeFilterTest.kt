package template.tags

import template.base.AttributeImpl
import template.base.AttributeWithValueImpl
import kotlin.test.Test
import kotlin.test.assertEquals

class AttributeFilterTest {
    @Test
    fun `filterTrue filters all false values`() {
        assertEquals(
            arrayOf(
                BoolAttribute("a", true),
                BoolAttribute("c", true),
            ).size,
            AttributeFilter.filterTrue(
                BoolAttribute("a", true),
                BoolAttribute("b", false),
                BoolAttribute("c", true),
            ).size
        )
    }

    @Test
    fun `filterTrue filters all false values with duplicates`() {
        assertEquals(
            arrayOf(
                BoolAttribute("a", true),
                BoolAttribute("b", true),
                BoolAttribute("c", true),
            ).size,
            AttributeFilter.filterTrue(
                BoolAttribute("a", true),
                BoolAttribute("b", false),
                BoolAttribute("c", true),
                BoolAttribute("b", true),
            ).size
        )
    }

    @Test
    fun `filterNotNull filters all null values`() {
        assertEquals(
            arrayOf(
                AttributeWithValueImpl("a", "1"),
                AttributeWithValueImpl("c", "3"),
            ).size,
            AttributeFilter.filterNotNull(
                AttributeWithValueImpl("a", "1"),
                AttributeImpl("b"),
                AttributeWithValueImpl("c", "3"),
            ).size
        )
    }

    @Test
    fun `filterNotNull filters all null values with duplicates`() {
        assertEquals(
            arrayOf(
                AttributeWithValueImpl("a", "1"),
                AttributeWithValueImpl("b", "2"),
                AttributeWithValueImpl("c", "3"),
            ).size,
            AttributeFilter.filterNotNull(
                AttributeWithValueImpl("a", "1"),
                AttributeImpl("b"),
                AttributeWithValueImpl("c", "3"),
                AttributeWithValueImpl("b", "2"),
            ).size
        )
    }
}
