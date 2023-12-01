package template_lib.tags

import io.mockative.*
import template_lib.Callable
import template_lib.base.TagWithAttributes
import template_lib.base.get
import kotlin.test.Test
import kotlin.test.assertEquals

class DetailsTest {
    @Mock
    val blockSummary = mock(classOf<Fun1<Summary, Unit>>())

    @Test
    fun `tag name is details`() {
        val tag = Details()

        assertEquals("details", tag.name)
    }

    @Test
    fun `tag name is summary`() {
        val tag = Summary()

        assertEquals("summary", tag.name)
    }

    @Test
    fun `summary function works`() {
        val tag = Details()
        every { blockSummary.invoke(any()) }.returns(Unit)

        val summary = tag.summary("a"["b"], clazz = "clazz", init = blockSummary::invoke)

        verificationWithClass(summary, blockSummary)
    }

    @Test
    fun `summary function works without class`() {
        val tag = Details()
        every { blockSummary.invoke(any()) }.returns(Unit)

        val summary = tag.summary("a"["b"], init = blockSummary::invoke)

        verificationWithoutClass(summary, blockSummary)
    }

    private fun <Tag: TagWithAttributes> verificationWithClass(
        tag: Tag,
        callable: Fun1<Tag, Unit>,
        expectedMap: Map<String, List<String?>> = mapOf(
            "a" to listOf("b"),
            "class" to listOf("clazz"),
        )
    ) {
        verify { callable.invoke(tag) }
            .wasInvoked(exactly = once)

        assertEquals(expectedMap, tag.attributes)
    }

    private fun <Tag: TagWithAttributes> verificationWithoutClass(
        tag: Tag,
        callable: Fun1<Tag, Unit>,
        expectedMap: Map<String, List<String?>> = mapOf(
            "a" to listOf("b")
        )
    ) {
        verify { callable.invoke(tag) }
            .wasInvoked(exactly = once)

        assertEquals(expectedMap, tag.attributes)
    }
}
