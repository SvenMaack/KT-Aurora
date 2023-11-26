package template_lib.tags

import io.mockative.*
import template_lib.Callable
import template_lib.base.TagWithAttributes
import kotlin.test.Test
import kotlin.test.assertEquals

class TextContainerTest {
    @Mock
    val blockAbbr = mock(classOf<Callable<Abbr>>())
    @Mock
    val blockCite = mock(classOf<Callable<Cite>>())
    @Mock
    val blockCode = mock(classOf<Callable<Code>>())
    @Mock
    val blockData = mock(classOf<Callable<Data>>())
    @Mock
    val blockDfn= mock(classOf<Callable<Dfn>>())
    @Mock
    val blockEm= mock(classOf<Callable<Em>>())

    @Test
    fun `abbr function works`() {
        val tag = TextContainer("tag")
        val abbr = tag.abbr("title123", init = blockAbbr::test)
        verificationWithClass(abbr, blockAbbr, mapOf(
            "title" to listOf("title123")
        ))
    }

    @Test
    fun `cite function works`() {
        val tag = TextContainer("tag")
        val cite = tag.cite(init = blockCite::test)
        verificationWithClass(cite, blockCite, mapOf())
    }

    @Test
    fun `code function works`() {
        val tag = TextContainer("tag")
        val code = tag.code(init = blockCode::test)
        verificationWithClass(code, blockCode, mapOf())
    }

    @Test
    fun `data function works`() {
        val tag = TextContainer("tag")
        val data = tag.data(init = blockData::test)
        verificationWithClass(data, blockData, mapOf())
    }

    @Test
    fun `dfn function works`() {
        val tag = TextContainer("tag")
        val dfn = tag.dfn(init = blockDfn::test)
        verificationWithClass(dfn, blockDfn, mapOf())
    }

    @Test
    fun `em function works`() {
        val tag = TextContainer("tag")
        val em = tag.em(init = blockEm::test)
        verificationWithClass(em, blockEm, mapOf())
    }

    private fun <Tag: TagWithAttributes> verificationWithClass(
        tag: Tag,
        callable: Callable<Tag>,
        expectedMap: Map<String, List<String?>>
    ) {
        verify { callable.test(tag) }
            .wasInvoked(exactly = once)

        assertEquals(expectedMap, tag.attributes)
    }
}
