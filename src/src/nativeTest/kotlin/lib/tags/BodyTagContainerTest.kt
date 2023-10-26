package lib.tags

import io.mockative.*
import lib.base.TagWithAttributes
import kotlin.test.Test
import lib.base.get
import kotlin.test.assertEquals

class BodyTagContainerTest {
    @Mock
    val blockP = mock(classOf<Callable<P>>())
    @Mock
    val blockSpan = mock(classOf<Callable<Span>>())
    @Mock
    val blockH1 = mock(classOf<Callable<H1>>())
    @Mock
    val blockH2 = mock(classOf<Callable<H2>>())
    @Mock
    val blockH3 = mock(classOf<Callable<H3>>())
    @Mock
    val blockH4 = mock(classOf<Callable<H4>>())
    @Mock
    val blockH5 = mock(classOf<Callable<H5>>())
    @Mock
    val blockH6 = mock(classOf<Callable<H6>>())
    @Mock
    val blockDiv = mock(classOf<Callable<Div>>())

    @Test
    fun `test p function works`() {
        val tag = BodyTagContainer("tag")
        val p = tag.p("a"["b"], clazz = "clazz", init = blockP::test)
        verificate(p, blockP)
    }

    @Test
    fun `test span function works`() {
        val tag = BodyTagContainer("tag")
        val span = tag.span("a"["b"], clazz = "clazz", init = blockSpan::test)
        verificate(span, blockSpan)
    }

    @Test
    fun `test h1 function works`() {
        val tag = BodyTagContainer("tag")
        val h1 = tag.h1("a"["b"], clazz = "clazz", init = blockH1::test)
        verificate(h1, blockH1)
    }

    @Test
    fun `test h2 function works`() {
        val tag = BodyTagContainer("tag")
        val h2 = tag.h2("a"["b"], clazz = "clazz", init = blockH2::test)
        verificate(h2, blockH2)
    }

    @Test
    fun `test h3 function works`() {
        val tag = BodyTagContainer("tag")
        val h3 = tag.h3("a"["b"], clazz = "clazz", init = blockH3::test)
        verificate(h3, blockH3)
    }

    @Test
    fun `test h4 function works`() {
        val tag = BodyTagContainer("tag")
        val h4 = tag.h4("a"["b"], clazz = "clazz", init = blockH4::test)
        verificate(h4, blockH4)
    }

    @Test
    fun `test h5 function works`() {
        val tag = BodyTagContainer("tag")
        val h5 = tag.h5("a"["b"], clazz = "clazz", init = blockH5::test)
        verificate(h5, blockH5)
    }

    @Test
    fun `test h6 function works`() {
        val tag = BodyTagContainer("tag")
        val h6 = tag.h6("a"["b"], clazz = "clazz", init = blockH6::test)
        verificate(h6, blockH6)
    }

    @Test
    fun `test div function works`() {
        val tag = BodyTagContainer("tag")
        val div = tag.div("a"["b"], clazz = "clazz", init = blockDiv::test)
        verificate(div, blockDiv)
    }

    @Test
    fun `test br function works`() {
        val tag = BodyTagContainer("tag")
        val br = tag.br()

        assertEquals("br", br.name)
    }

    @Test
    fun `test hr function works`() {
        val tag = BodyTagContainer("tag")
        val hr = tag.hr()

        assertEquals("hr", hr.name)
    }

    private fun <Tag: TagWithAttributes>verificate(tag: Tag, callable: Callable<Tag>) {
        verify { callable.test(tag) }
            .wasInvoked(exactly = once)

        assertEquals(mapOf(
            "a" to listOf("b"),
            "class" to listOf("clazz"),
        ), tag.attributes)
    }
}
