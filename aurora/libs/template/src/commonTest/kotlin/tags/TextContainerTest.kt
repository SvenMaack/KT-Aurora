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
    @Mock
    val blockMark= mock(classOf<Callable<Mark>>())
    @Mock
    val blockOutput= mock(classOf<Callable<Output>>())
    @Mock
    val blockPre= mock(classOf<Callable<Pre>>())
    @Mock
    val blockSub= mock(classOf<Callable<Sub>>())

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

    @Test
    fun `mark function works`() {
        val tag = TextContainer("tag")
        val mark = tag.mark(init = blockMark::test)
        verificationWithClass(mark, blockMark, mapOf())
    }

    @Test
    fun `output function works`() {
        val tag = TextContainer("tag")
        val output = tag.output(init = blockOutput::test)
        verificationWithClass(output, blockOutput, mapOf())
    }

    @Test
    fun `pre function works`() {
        val tag = TextContainer("tag")
        val pre = tag.pre(init = blockPre::test)
        verificationWithClass(pre, blockPre, mapOf())
    }

    @Test
    fun `sub function works`() {
        val tag = TextContainer("tag")
        val sub = tag.sub(init = blockSub::test)
        verificationWithClass(sub, blockSub, mapOf())
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
