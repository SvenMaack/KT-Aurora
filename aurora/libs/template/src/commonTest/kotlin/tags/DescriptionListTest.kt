package template_lib.tags

import io.mockative.*
import template_lib.Callable
import template_lib.base.TagWithAttributes
import template_lib.base.get
import kotlin.test.Test
import kotlin.test.assertEquals

class DescriptionListTest {
    @Mock
    val blockDt = mock(classOf<Callable<Dt>>())
    @Mock
    val blockDd = mock(classOf<Callable<Dd>>())

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
        val dt = tag.dt("a"["b"], clazz = "clazz", init = blockDt::test)
        verificationWithClass(dt, blockDt)
    }

    @Test
    fun `dt function works without class`() {
        val tag = Dl()
        val dt = tag.dt("a"["b"], init = blockDt::test)
        verificationWithoutClass(dt, blockDt)
    }

    @Test
    fun `dd function works`() {
        val tag = Dl()
        val dd = tag.dd("a"["b"], clazz = "clazz", init = blockDd::test)
        verificationWithClass(dd, blockDd)
    }

    @Test
    fun `dd function works without class`() {
        val tag = Dl()
        val dd = tag.dd("a"["b"], init = blockDd::test)
        verificationWithoutClass(dd, blockDd)
    }

    private fun <Tag: TagWithAttributes> verificationWithClass(
        tag: Tag,
        callable: Callable<Tag>,
        expectedMap: Map<String, List<String?>> = mapOf(
            "a" to listOf("b"),
            "class" to listOf("clazz"),
        )
    ) {
        verify { callable.test(tag) }
            .wasInvoked(exactly = once)

        assertEquals(expectedMap, tag.attributes)
    }

    private fun <Tag: TagWithAttributes> verificationWithoutClass(
        tag: Tag,
        callable: Callable<Tag>,
        expectedMap: Map<String, List<String?>> = mapOf(
            "a" to listOf("b")
        )
    ) {
        verify { callable.test(tag) }
            .wasInvoked(exactly = once)

        assertEquals(expectedMap, tag.attributes)
    }
}
