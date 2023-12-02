package template.tags

import io.mockative.*
import template.base.TagWithAttributes
import template.base.get
import kotlin.test.Test
import kotlin.test.assertEquals

class SelectTest {
    @Mock
    val blockOptGroup = mock(classOf<Fun1<OptGroup, Unit>>())

    @Test
    fun `tag name is select`() {
        val tag = Select("id1")

        assertEquals("select", tag.name)
        assertEquals("id1", tag.id)
    }

    @Test
    fun `optGroup function works`() {
        val select = Select("id1")
        every { blockOptGroup.invoke(any()) }.returns(Unit)

        val optGroup = select.optGroup("a"["b"], disabled = true, label = "l1", clazz = "clazz", init = blockOptGroup::invoke)

        verification(optGroup, blockOptGroup, mapOf(
                "a" to listOf("b"),
                "disabled" to listOf(null),
                "label" to listOf("l1"),
                "class" to listOf("clazz")
            )
        )
    }

    @Test
    fun `optGroup function works without class`() {
        val select = Select("id1")
        every { blockOptGroup.invoke(any()) }.returns(Unit)

        val optGroup = select.optGroup("a"["b"], disabled = true, label = "l1", init = blockOptGroup::invoke)

        verification(optGroup, blockOptGroup, mapOf(
                "a" to listOf("b"),
                "disabled" to listOf(null),
                "label" to listOf("l1"),
            )
        )
    }

    @Test
    fun `optGroup function works without disabled`() {
        val select = Select("id1")
        every { blockOptGroup.invoke(any()) }.returns(Unit)

        val optGroup = select.optGroup("a"["b"], label = "l1", disabled = false, init = blockOptGroup::invoke)

        verification(optGroup, blockOptGroup, mapOf(
                "a" to listOf("b"),
                "label" to listOf("l1"),
            )
        )
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
