package template.tags

import io.mockative.*
import template.base.TagWithAttributes
import template.base.get
import kotlin.test.Test
import kotlin.test.assertEquals

class OptGroupTest {
    @Mock
    val blockOption = mock(classOf<Fun1<Option, Unit>>())

    @Test
    fun `tag name is optgroup`() {
        val tag = OptGroup()

        assertEquals("optgroup", tag.name)
    }

    @Test
    fun `option function works`() {
        val optGroup = OptGroup()
        every { blockOption.invoke(any()) }.returns(Unit)

        val option = optGroup.option("a"["b"], label = "l1", value = "v1", init = blockOption::invoke)

        verification(option, blockOption, mapOf(
            "a" to listOf("b"),
            "label" to listOf("l1"),
            "value" to listOf("v1"),
        ))
    }

    @Test
    fun `option function works without optionals`() {
        val optGroup = OptGroup()
        every { blockOption.invoke(any()) }.returns(Unit)

        val option = optGroup.option("a"["b"], disabled = true, selected = true, label = "l1",  value = "v1", clazz = "clazz", init = blockOption::invoke)

        verification(option, blockOption, mapOf(
            "a" to listOf("b"),
            "disabled" to listOf(null),
            "selected" to listOf(null),
            "label" to listOf("l1"),
            "value" to listOf("v1"),
            "class" to listOf("clazz")
        ))
    }

    private fun <Tag : TagWithAttributes> verification(
        tag: Tag,
        callable: Fun1<Tag, Unit>,
        expectedMap: Map<String, List<String?>>
    ) {
        verify { callable.invoke(tag) }
            .wasInvoked(exactly = once)

        expectedMap.forEach { (key, value) ->
            assertEquals(value, tag.attributes[key], key)
        }
        assertEquals(expectedMap.keys.sorted(), tag.attributes.keys.sorted())
    }
}
