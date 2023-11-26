package template_lib.tags

import io.mockative.*
import template_lib.Callable
import template_lib.base.TagWithAttributes
import kotlin.test.Test
import template_lib.base.get
import template_lib.tags.enums.AudioType
import template_lib.tags.enums.GeneralLanguage
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
    @Mock
    val blockNav = mock(classOf<Callable<Nav>>())
    @Mock
    val blockUl = mock(classOf<Callable<Ul>>())
    @Mock
    val blockOl = mock(classOf<Callable<Ol>>())
    @Mock
    val blockA = mock(classOf<Callable<A>>())
    @Mock
    val blockArticle = mock(classOf<Callable<Article>>())
    @Mock
    val blockAside = mock(classOf<Callable<Aside>>())
    @Mock
    val blockAddress = mock(classOf<Callable<Address>>())

    @Test
    fun `p function works`() {
        val tag = BodyTagContainer("tag")
        val p = tag.p("a"["b"], clazz = "clazz", init = blockP::test)
        verificationWithClass(p, blockP)
    }

    @Test
    fun `p function works without class`() {
        val tag = BodyTagContainer("tag")
        val p = tag.p("a"["b"], init = blockP::test)
        verificationWithoutClass(p, blockP)
    }

    @Test
    fun `span function works`() {
        val tag = BodyTagContainer("tag")
        val span = tag.span("a"["b"], clazz = "clazz", init = blockSpan::test)
        verificationWithClass(span, blockSpan)
    }

    @Test
    fun `span function works without class`() {
        val tag = BodyTagContainer("tag")
        val span = tag.span("a"["b"], init = blockSpan::test)
        verificationWithoutClass(span, blockSpan)
    }

    @Test
    fun `address function works`() {
        val tag = BodyTagContainer("tag")
        val address = tag.address("a"["b"], title = "title1", init = blockAddress::test)
        verificationWithClass(address, blockAddress, mapOf(
            "a" to listOf("b"),
            "title" to listOf("title1"),
        ))
    }

    @Test
    fun `h1 function works`() {
        val tag = BodyTagContainer("tag")
        val h1 = tag.h1("a"["b"], clazz = "clazz", init = blockH1::test)
        verificationWithClass(h1, blockH1)
    }

    @Test
    fun `h1 function works without class`() {
        val tag = BodyTagContainer("tag")
        val h1 = tag.h1("a"["b"], init = blockH1::test)
        verificationWithoutClass(h1, blockH1)
    }

    @Test
    fun `h2 function works`() {
        val tag = BodyTagContainer("tag")
        val h2 = tag.h2("a"["b"], clazz = "clazz", init = blockH2::test)
        verificationWithClass(h2, blockH2)
    }

    @Test
    fun `h2 function works without class`() {
        val tag = BodyTagContainer("tag")
        val h2 = tag.h2("a"["b"], init = blockH2::test)
        verificationWithoutClass(h2, blockH2)
    }

    @Test
    fun `h3 function works`() {
        val tag = BodyTagContainer("tag")
        val h3 = tag.h3("a"["b"], clazz = "clazz", init = blockH3::test)
        verificationWithClass(h3, blockH3)
    }

    @Test
    fun `h3 function works without class`() {
        val tag = BodyTagContainer("tag")
        val h3 = tag.h3("a"["b"], init = blockH3::test)
        verificationWithoutClass(h3, blockH3)
    }

    @Test
    fun `h4 function works`() {
        val tag = BodyTagContainer("tag")
        val h4 = tag.h4("a"["b"], clazz = "clazz", init = blockH4::test)
        verificationWithClass(h4, blockH4)
    }

    @Test
    fun `h4 function works without class`() {
        val tag = BodyTagContainer("tag")
        val h4 = tag.h4("a"["b"], init = blockH4::test)
        verificationWithoutClass(h4, blockH4)
    }

    @Test
    fun `h5 function works`() {
        val tag = BodyTagContainer("tag")
        val h5 = tag.h5("a"["b"], clazz = "clazz", init = blockH5::test)
        verificationWithClass(h5, blockH5)
    }

    @Test
    fun `h5 function works withput class`() {
        val tag = BodyTagContainer("tag")
        val h5 = tag.h5("a"["b"], init = blockH5::test)
        verificationWithoutClass(h5, blockH5)
    }

    @Test
    fun `h6 function works`() {
        val tag = BodyTagContainer("tag")
        val h6 = tag.h6("a"["b"], clazz = "clazz", init = blockH6::test)
        verificationWithClass(h6, blockH6)
    }

    @Test
    fun `h6 function works without class`() {
        val tag = BodyTagContainer("tag")
        val h6 = tag.h6("a"["b"], init = blockH6::test)
        verificationWithoutClass(h6, blockH6)
    }

    @Test
    fun `div function works`() {
        val tag = BodyTagContainer("tag")
        val div = tag.div("a"["b"], clazz = "clazz", init = blockDiv::test)
        verificationWithClass(div, blockDiv)
    }

    @Test
    fun `div function works without class`() {
        val tag = BodyTagContainer("tag")
        val div = tag.div("a"["b"], init = blockDiv::test)
        verificationWithoutClass(div, blockDiv)
    }

    @Test
    fun `article function works`() {
        val tag = BodyTagContainer("tag")
        val article = tag.article("a"["b"], clazz = "clazz", init = blockArticle::test)
        verificationWithClass(article, blockArticle)
    }

    @Test
    fun `article function works without class`() {
        val tag = BodyTagContainer("tag")
        val article = tag.article("a"["b"], init = blockArticle::test)
        verificationWithoutClass(article, blockArticle)
    }

    @Test
    fun `aside function works`() {
        val tag = BodyTagContainer("tag")
        val aside = tag.aside("a"["b"], clazz = "clazz", init = blockAside::test)
        verificationWithClass(aside, blockAside)
    }

    @Test
    fun `aside function works without class`() {
        val tag = BodyTagContainer("tag")
        val aside = tag.aside("a"["b"], init = blockAside::test)
        verificationWithoutClass(aside, blockAside)
    }

    @Test
    fun `nav function works`() {
        val tag = BodyTagContainer("tag")
        val nav = tag.nav("a"["b"], clazz = "clazz", init = blockNav::test)
        verificationWithClass(nav, blockNav)
    }

    @Test
    fun `nav function works without class`() {
        val tag = BodyTagContainer("tag")
        val nav = tag.nav("a"["b"], init = blockNav::test)
        verificationWithoutClass(nav, blockNav)
    }

    @Test
    fun `ul function works`() {
        val tag = BodyTagContainer("tag")
        val nav = tag.ul("a"["b"], clazz = "clazz", init = blockUl::test)
        verificationWithClass(nav, blockUl)
    }

    @Test
    fun `ul function works without class`() {
        val tag = BodyTagContainer("tag")
        val nav = tag.ul("a"["b"], init = blockUl::test)
        verificationWithoutClass(nav, blockUl)
    }

    @Test
    fun `ol function works`() {
        val tag = BodyTagContainer("tag")
        val nav = tag.ol("a"["b"], clazz = "clazz", init = blockOl::test)
        verificationWithClass(nav, blockOl)
    }

    @Test
    fun `ol function works without class`() {
        val tag = BodyTagContainer("tag")
        val nav = tag.ol("a"["b"], init = blockOl::test)
        verificationWithoutClass(nav, blockOl)
    }

    @Test
    fun `a function works`() {
        val tag = BodyTagContainer("tag")
        val a = tag.a("a"["b"], href = "link", clazz = "clazz", init = blockA::test)
        verificationWithClass(a, blockA, mapOf(
            "a" to listOf("b"),
            "href" to listOf("link"),
            "class" to listOf("clazz"),
        ))
    }

    @Test
    fun `a function works without class`() {
        val tag = BodyTagContainer("tag")
        val a = tag.a(href = "link", init = blockA::test)
        verificationWithoutClass(a, blockA, mapOf(
            "href" to listOf("link"),
        ))
    }

    @Test
    fun `a function works with all attributes`() {
        val tag = BodyTagContainer("tag")
        val a = tag.a(
            "a"["b"],
            href = "link",
            clazz = "clazz",
            type = AudioType.WAV,
            download = true,
            target = Target.SELF,
            hrefLang = GeneralLanguage.English,
            referrerPolicy = ReferrerPolicy.ORIGIN,
            rel = Rel.TAG,
            pings = listOf("a", "b"),
            init = blockA::test
        )
        verificationWithClass(a, blockA, mapOf(
            "a" to listOf("b"),
            "href" to listOf("link"),
            "type" to listOf(AudioType.WAV.value),
            "target" to listOf(Target.SELF.value),
            "download" to listOf(null),
            "class" to listOf("clazz"),
            "hreflang" to listOf(GeneralLanguage.English.value),
            "referrerpolicy" to listOf(ReferrerPolicy.ORIGIN.value),
            "rel" to listOf(Rel.TAG.value),
            "ping" to listOf("a b"),
        ))
    }

    @Test
    fun `a function works with all attributes if one is null`() {
        val tag = BodyTagContainer("tag")
        val a = tag.a(
            href = "link",
            clazz = "clazz",
            type = AudioType.WAV,
            download = true,
            target = Target.SELF,
            hrefLang = null, //<--
            referrerPolicy = ReferrerPolicy.ORIGIN,
            rel = Rel.TAG,
            pings = listOf("a", "b"),
            init = blockA::test
        )
        verificationWithClass(a, blockA, mapOf(
            "href" to listOf("link"),
            "type" to listOf(AudioType.WAV.value),
            "target" to listOf(Target.SELF.value),
            "download" to listOf(null),
            "class" to listOf("clazz"),
            //"hreflang" to listOf("de"),
            "referrerpolicy" to listOf(ReferrerPolicy.ORIGIN.value),
            "rel" to listOf(Rel.TAG.value),
            "ping" to listOf("a b"),
        ))
    }

    @Test
    fun `br function works`() {
        val tag = BodyTagContainer("tag")
        val br = tag.br()

        assertEquals("br", br.name)
    }

    @Test
    fun `hr function works`() {
        val tag = BodyTagContainer("tag")
        val hr = tag.hr()

        assertEquals("hr", hr.name)
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
