package template.tags

import io.mockative.*
import template.base.TagWithAttributes
import kotlin.test.Test
import kotlin.test.assertEquals

class TextContainerTest {
    @Mock
    val blockAbbr = mock(classOf<Fun1<Abbr, Unit>>())
    @Mock
    val blockCite = mock(classOf<Fun1<Cite, Unit>>())
    @Mock
    val blockCode = mock(classOf<Fun1<Code, Unit>>())
    @Mock
    val blockData = mock(classOf<Fun1<Data, Unit>>())
    @Mock
    val blockDfn= mock(classOf<Fun1<Dfn, Unit>>())
    @Mock
    val blockEm= mock(classOf<Fun1<Em, Unit>>())
    @Mock
    val blockMark= mock(classOf<Fun1<Mark, Unit>>())
    @Mock
    val blockOutput= mock(classOf<Fun1<Output, Unit>>())
    @Mock
    val blockPre= mock(classOf<Fun1<Pre, Unit>>())
    @Mock
    val blockSub= mock(classOf<Fun1<Sub, Unit>>())
    @Mock
    val blockSup= mock(classOf<Fun1<Sup, Unit>>())
    @Mock
    val blockTime= mock(classOf<Fun1<Time, Unit>>())
    @Mock
    val blockVar = mock(classOf<Fun1<Var, Unit>>())

    @Test
    fun `abbr function works`() {
        val tag = TextContainer("tag")
        every { blockAbbr.invoke(any()) }.returns(Unit)

        val abbr = tag.abbr("title123", init = blockAbbr::invoke)

        verificationWithClass(abbr, blockAbbr, mapOf(
            "title" to listOf("title123")
        ))
    }

    @Test
    fun `cite function works`() {
        val tag = TextContainer("tag")
        every { blockCite.invoke(any()) }.returns(Unit)

        val cite = tag.cite(init = blockCite::invoke)

        verificationWithClass(cite, blockCite, mapOf())
    }

    @Test
    fun `code function works`() {
        val tag = TextContainer("tag")
        every { blockCode.invoke(any()) }.returns(Unit)

        val code = tag.code(init = blockCode::invoke)

        verificationWithClass(code, blockCode, mapOf())
    }

    @Test
    fun `data function works`() {
        val tag = TextContainer("tag")
        every { blockData.invoke(any()) }.returns(Unit)

        val data = tag.data(init = blockData::invoke)

        verificationWithClass(data, blockData, mapOf())
    }

    @Test
    fun `dfn function works`() {
        val tag = TextContainer("tag")
        every { blockDfn.invoke(any()) }.returns(Unit)

        val dfn = tag.dfn(init = blockDfn::invoke)

        verificationWithClass(dfn, blockDfn, mapOf())
    }

    @Test
    fun `em function works`() {
        val tag = TextContainer("tag")
        every { blockEm.invoke(any()) }.returns(Unit)

        val em = tag.em(init = blockEm::invoke)

        verificationWithClass(em, blockEm, mapOf())
    }

    @Test
    fun `mark function works`() {
        val tag = TextContainer("tag")
        every { blockMark.invoke(any()) }.returns(Unit)

        val mark = tag.mark(init = blockMark::invoke)

        verificationWithClass(mark, blockMark, mapOf())
    }

    @Test
    fun `output function works`() {
        val tag = TextContainer("tag")
        every { blockOutput.invoke(any()) }.returns(Unit)

        val output = tag.output(init = blockOutput::invoke)

        verificationWithClass(output, blockOutput, mapOf())
    }

    @Test
    fun `pre function works`() {
        val tag = TextContainer("tag")
        every { blockPre.invoke(any()) }.returns(Unit)

        val pre = tag.pre(init = blockPre::invoke)

        verificationWithClass(pre, blockPre, mapOf())
    }

    @Test
    fun `sub function works`() {
        val tag = TextContainer("tag")
        every { blockSub.invoke(any()) }.returns(Unit)

        val sub = tag.sub(init = blockSub::invoke)

        verificationWithClass(sub, blockSub, mapOf())
    }

    @Test
    fun `sup function works`() {
        val tag = TextContainer("tag")
        every { blockSup.invoke(any()) }.returns(Unit)

        val sup = tag.sup(init = blockSup::invoke)

        verificationWithClass(sup, blockSup, mapOf())
    }

    @Test
    fun `time function works`() {
        val tag = TextContainer("tag")
        every { blockTime.invoke(any()) }.returns(Unit)

        val time = tag.time(init = blockTime::invoke)

        verificationWithClass(time, blockTime, mapOf())
    }

    @Test
    fun `var function works`() {
        val tag = TextContainer("tag")
        every { blockVar.invoke(any()) }.returns(Unit)

        val `var` = tag.`var`(init = blockVar::invoke)

        verificationWithClass(`var`, blockVar, mapOf())
    }

    private fun <Tag: TagWithAttributes> verificationWithClass(
        tag: Tag,
        callable: Fun1<Tag, Unit>,
        expectedMap: Map<String, List<String?>>
    ) {
        verify { callable.invoke(tag) }
            .wasInvoked(exactly = once)

        assertEquals(expectedMap, tag.attributes)
    }
}
