package template_lib.tags

import io.mockative.*
import template_lib.Callable
import template_lib.base.TagWithAttributes
import template_lib.base.get
import kotlin.test.Test
import kotlin.test.assertEquals

class DescriptionListTest {
    @Mock
    val blockDt = mock(classOf<Fun1<Dt, Unit>>())
    @Mock
    val blockDd = mock(classOf<Fun1<Dd, Unit>>())

    @Test
    fun `tag name is dl`() {
        val tag = Dl()

        assertEquals("dl", tag.name)
    }

    @Test
    fun `tag name is dt`() {
        val tag = Dt()

        assertEquals("dt", tag.name)
    }

    @Test
    fun `tag name is dd`() {
        val tag = Dd()

        assertEquals("dd", tag.name)
    }

    @Test
    fun `dt function works`() {
        val tag = Dl()
        every { blockDt.invoke(any()) }.returns(Unit)

        val dt = tag.dt("a"["b"], clazz = "clazz", init = blockDt::invoke)

        verificationWithClass(dt, blockDt)
    }

    @Test
    fun `dt function works without class`() {
        val tag = Dl()
        every { blockDt.invoke(any()) }.returns(Unit)

        val dt = tag.dt("a"["b"], init = blockDt::invoke)

        verificationWithoutClass(dt, blockDt)
    }

    @Test
    fun `dd function works`() {
        val tag = Dl()
        every { blockDd.invoke(any()) }.returns(Unit)

        val dd = tag.dd("a"["b"], clazz = "clazz", init = blockDd::invoke)

        verificationWithClass(dd, blockDd)
    }

    @Test
    fun `dd function works without class`() {
        val tag = Dl()
        every { blockDd.invoke(any()) }.returns(Unit)

        val dd = tag.dd("a"["b"], init = blockDd::invoke)

        verificationWithoutClass(dd, blockDd)
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
