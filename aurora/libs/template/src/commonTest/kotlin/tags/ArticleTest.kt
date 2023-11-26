package template_lib.tags

import io.mockative.*
import template_lib.Callable
import template_lib.base.TagWithAttributes
import template_lib.base.get
import kotlin.test.Test
import kotlin.test.assertEquals

class ArticleTest {
    @Mock
    val blockHeader = mock(classOf<Callable<Header>>())

    @Test
    fun `tag name is article`() {
        val tag = Article()
        assertEquals("article", tag.name)
    }

    @Test
    fun `p function works`() {
        val tag = Article()
        val header = tag.header("a"["b"], clazz = "clazz", init = blockHeader::test)
        verificationWithClass(header, blockHeader)
    }

    @Test
    fun `p function works without class`() {
        val tag = Article()
        val header = tag.header("a"["b"], init = blockHeader::test)
        verificationWithoutClass(header, blockHeader)
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
