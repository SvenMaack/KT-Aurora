package template.tags

import io.mockative.*
import template.base.TagWithAttributes
import kotlin.test.Test
import template.base.*
import template.tags.enums.*
import template.tags.enums.AudioType
import template.tags.enums.GeneralLanguage
import kotlin.test.assertEquals

class BodyTagContainerTest {
    @Mock
    val blockP = mock(classOf<Fun1<P, Unit>>())
    @Mock
    val blockSpan = mock(classOf<Fun1<Span, Unit>>())
    @Mock
    val blockBlockQuote = mock(classOf<Fun1<BlockQuote, Unit>>())
    @Mock
    val blockH1 = mock(classOf<Fun1<H1, Unit>>())
    @Mock
    val blockH2 = mock(classOf<Fun1<H2, Unit>>())
    @Mock
    val blockH3 = mock(classOf<Fun1<H3, Unit>>())
    @Mock
    val blockH4 = mock(classOf<Fun1<H4, Unit>>())
    @Mock
    val blockH5 = mock(classOf<Fun1<H5, Unit>>())
    @Mock
    val blockH6 = mock(classOf<Fun1<H6, Unit>>())
    @Mock
    val blockDiv = mock(classOf<Fun1<Div, Unit>>())
    @Mock
    val blockTemplate = mock(classOf<Fun1<Template, Unit>>())
    @Mock
    val blockSection = mock(classOf<Fun1<Section, Unit>>())
    @Mock
    val blockNav = mock(classOf<Fun1<Nav, Unit>>())
    @Mock
    val blockMain = mock(classOf<Fun1<Main, Unit>>())
    @Mock
    val blockFooter = mock(classOf<Fun1<Footer, Unit>>())
    @Mock
    val blockUl = mock(classOf<Fun1<Ul, Unit>>())
    @Mock
    val blockOl = mock(classOf<Fun1<Ol, Unit>>())
    @Mock
    val blockMenu = mock(classOf<Fun1<Menu, Unit>>())
    @Mock
    val blockDl = mock(classOf<Fun1<Dl, Unit>>())
    @Mock
    val blockA = mock(classOf<Fun1<A, Unit>>())
    @Mock
    val blockForm = mock(classOf<Fun1<Form, Unit>>())
    @Mock
    val blockArticle = mock(classOf<Fun1<Article, Unit>>())
    @Mock
    val blockAside = mock(classOf<Fun1<Aside, Unit>>())
    @Mock
    val blockAddress = mock(classOf<Fun1<Address, Unit>>())
    @Mock
    val blockDetails = mock(classOf<Fun1<Details, Unit>>())

    @Test
    fun `p function works`() {
        val tag = BodyTagContainer("tag")
        every { blockP.invoke(any()) }.returns(Unit)

        val p = tag.p("a"["b"], clazz = "clazz", init = blockP::invoke)

        verificationWithClass(p, blockP)
    }

    @Test
    fun `p function works without class`() {
        val tag = BodyTagContainer("tag")
        every { blockP.invoke(any()) }.returns(Unit)

        val p = tag.p("a"["b"], init = blockP::invoke)

        verificationWithoutClass(p, blockP)
    }

    @Test
    fun `span function works`() {
        val tag = BodyTagContainer("tag")
        every { blockSpan.invoke(any()) }.returns(Unit)

        val span = tag.span("a"["b"], clazz = "clazz", init = blockSpan::invoke)
        verificationWithClass(span, blockSpan)
    }

    @Test
    fun `span function works without class`() {
        val tag = BodyTagContainer("tag")
        every { blockSpan.invoke(any()) }.returns(Unit)

        val span = tag.span("a"["b"], init = blockSpan::invoke)

        verificationWithoutClass(span, blockSpan)
    }

    @Test
    fun `blockQuote function works`() {
        val tag = BodyTagContainer("tag")
        every { blockBlockQuote.invoke(any()) }.returns(Unit)

        val blockQuote = tag.blockQuote("a"["b"], cite = "link", init = blockBlockQuote::invoke)

        verificationWithoutClass(blockQuote, blockBlockQuote, mapOf(
            "a" to listOf("b"),
            "cite" to listOf("link"),
        ))
    }

    @Test
    fun `address function works`() {
        val tag = BodyTagContainer("tag")
        every { blockAddress.invoke(any()) }.returns(Unit)

        val address = tag.address("a"["b"], title = "title1", init = blockAddress::invoke)

        verificationWithClass(address, blockAddress, mapOf(
            "a" to listOf("b"),
            "title" to listOf("title1"),
        ))
    }

    @Test
    fun `h1 function works`() {
        val tag = BodyTagContainer("tag")
        every { blockH1.invoke(any()) }.returns(Unit)

        val h1 = tag.h1("a"["b"], clazz = "clazz", init = blockH1::invoke)

        verificationWithClass(h1, blockH1)
    }

    @Test
    fun `h1 function works without class`() {
        val tag = BodyTagContainer("tag")
        every { blockH1.invoke(any()) }.returns(Unit)

        val h1 = tag.h1("a"["b"], init = blockH1::invoke)

        verificationWithoutClass(h1, blockH1)
    }

    @Test
    fun `h2 function works`() {
        val tag = BodyTagContainer("tag")
        every { blockH2.invoke(any()) }.returns(Unit)

        val h2 = tag.h2("a"["b"], clazz = "clazz", init = blockH2::invoke)

        verificationWithClass(h2, blockH2)
    }

    @Test
    fun `h2 function works without class`() {
        val tag = BodyTagContainer("tag")
        every { blockH2.invoke(any()) }.returns(Unit)

        val h2 = tag.h2("a"["b"], init = blockH2::invoke)

        verificationWithoutClass(h2, blockH2)
    }

    @Test
    fun `h3 function works`() {
        val tag = BodyTagContainer("tag")
        every { blockH3.invoke(any()) }.returns(Unit)

        val h3 = tag.h3("a"["b"], clazz = "clazz", init = blockH3::invoke)

        verificationWithClass(h3, blockH3)
    }

    @Test
    fun `h3 function works without class`() {
        val tag = BodyTagContainer("tag")
        every { blockH3.invoke(any()) }.returns(Unit)

        val h3 = tag.h3("a"["b"], init = blockH3::invoke)

        verificationWithoutClass(h3, blockH3)
    }

    @Test
    fun `h4 function works`() {
        val tag = BodyTagContainer("tag")
        every { blockH4.invoke(any()) }.returns(Unit)

        val h4 = tag.h4("a"["b"], clazz = "clazz", init = blockH4::invoke)

        verificationWithClass(h4, blockH4)
    }

    @Test
    fun `h4 function works without class`() {
        val tag = BodyTagContainer("tag")
        every { blockH4.invoke(any()) }.returns(Unit)

        val h4 = tag.h4("a"["b"], init = blockH4::invoke)

        verificationWithoutClass(h4, blockH4)
    }

    @Test
    fun `h5 function works`() {
        val tag = BodyTagContainer("tag")
        every { blockH5.invoke(any()) }.returns(Unit)

        val h5 = tag.h5("a"["b"], clazz = "clazz", init = blockH5::invoke)

        verificationWithClass(h5, blockH5)
    }

    @Test
    fun `h5 function works withput class`() {
        val tag = BodyTagContainer("tag")
        every { blockH5.invoke(any()) }.returns(Unit)

        val h5 = tag.h5("a"["b"], init = blockH5::invoke)

        verificationWithoutClass(h5, blockH5)
    }

    @Test
    fun `h6 function works`() {
        val tag = BodyTagContainer("tag")
        every { blockH6.invoke(any()) }.returns(Unit)

        val h6 = tag.h6("a"["b"], clazz = "clazz", init = blockH6::invoke)

        verificationWithClass(h6, blockH6)
    }

    @Test
    fun `h6 function works without class`() {
        val tag = BodyTagContainer("tag")
        every { blockH6.invoke(any()) }.returns(Unit)

        val h6 = tag.h6("a"["b"], init = blockH6::invoke)

        verificationWithoutClass(h6, blockH6)
    }

    @Test
    fun `div function works`() {
        val tag = BodyTagContainer("tag")
        every { blockDiv.invoke(any()) }.returns(Unit)

        val div = tag.div("a"["b"], clazz = "clazz", init = blockDiv::invoke)

        verificationWithClass(div, blockDiv)
    }

    @Test
    fun `div function works without class`() {
        val tag = BodyTagContainer("tag")
        every { blockDiv.invoke(any()) }.returns(Unit)

        val div = tag.div("a"["b"], init = blockDiv::invoke)

        verificationWithoutClass(div, blockDiv)
    }

    @Test
    fun `template function works`() {
        val tag = BodyTagContainer("tag")
        every { blockTemplate.invoke(any()) }.returns(Unit)

        val template = tag.template("a"["b"], clazz = "clazz", init = blockTemplate::invoke)

        verificationWithClass(template, blockTemplate)
    }

    @Test
    fun `template function works without class`() {
        val tag = BodyTagContainer("tag")
        every { blockTemplate.invoke(any()) }.returns(Unit)

        val template = tag.template("a"["b"], init = blockTemplate::invoke)

        verificationWithoutClass(template, blockTemplate)
    }

    @Test
    fun `section function works`() {
        val tag = BodyTagContainer("tag")
        every { blockSection.invoke(any()) }.returns(Unit)

        val section = tag.section("a"["b"], clazz = "clazz", init = blockSection::invoke)

        verificationWithClass(section, blockSection)
    }

    @Test
    fun `section function works without class`() {
        val tag = BodyTagContainer("tag")
        every { blockSection.invoke(any()) }.returns(Unit)

        val section = tag.section("a"["b"], init = blockSection::invoke)

        verificationWithoutClass(section, blockSection)
    }

    @Test
    fun `article function works`() {
        val tag = BodyTagContainer("tag")
        every { blockArticle.invoke(any()) }.returns(Unit)

        val article = tag.article("a"["b"], clazz = "clazz", init = blockArticle::invoke)

        verificationWithClass(article, blockArticle)
    }

    @Test
    fun `article function works without class`() {
        val tag = BodyTagContainer("tag")
        every { blockArticle.invoke(any()) }.returns(Unit)

        val article = tag.article("a"["b"], init = blockArticle::invoke)

        verificationWithoutClass(article, blockArticle)
    }

    @Test
    fun `aside function works`() {
        val tag = BodyTagContainer("tag")
        every { blockAside.invoke(any()) }.returns(Unit)

        val aside = tag.aside("a"["b"], clazz = "clazz", init = blockAside::invoke)

        verificationWithClass(aside, blockAside)
    }

    @Test
    fun `aside function works without class`() {
        val tag = BodyTagContainer("tag")
        every { blockAside.invoke(any()) }.returns(Unit)

        val aside = tag.aside("a"["b"], init = blockAside::invoke)

        verificationWithoutClass(aside, blockAside)
    }

    @Test
    fun `nav function works`() {
        val tag = BodyTagContainer("tag")
        every { blockNav.invoke(any()) }.returns(Unit)

        val nav = tag.nav("a"["b"], clazz = "clazz", init = blockNav::invoke)

        verificationWithClass(nav, blockNav)
    }

    @Test
    fun `nav function works without class`() {
        val tag = BodyTagContainer("tag")
        every { blockNav.invoke(any()) }.returns(Unit)

        val nav = tag.nav("a"["b"], init = blockNav::invoke)

        verificationWithoutClass(nav, blockNav)
    }

    @Test
    fun `main function works`() {
        val tag = BodyTagContainer("tag")
        every { blockMain.invoke(any()) }.returns(Unit)

        val main = tag.main("a"["b"], clazz = "clazz", init = blockMain::invoke)
        verificationWithClass(main, blockMain)
    }

    @Test
    fun `main function works without class`() {
        val tag = BodyTagContainer("tag")
        every { blockMain.invoke(any()) }.returns(Unit)

        val main = tag.main("a"["b"], init = blockMain::invoke)

        verificationWithoutClass(main, blockMain)
    }

    @Test
    fun `footer function works`() {
        val tag = BodyTagContainer("tag")
        every { blockFooter.invoke(any()) }.returns(Unit)

        val footer = tag.footer("a"["b"], clazz = "clazz", init = blockFooter::invoke)

        verificationWithClass(footer, blockFooter)
    }

    @Test
    fun `footer function works without class`() {
        val tag = BodyTagContainer("tag")
        every { blockFooter.invoke(any()) }.returns(Unit)

        val footer = tag.footer("a"["b"], init = blockFooter::invoke)

        verificationWithoutClass(footer, blockFooter)
    }

    @Test
    fun `ul function works`() {
        val tag = BodyTagContainer("tag")
        every { blockUl.invoke(any()) }.returns(Unit)

        val ul = tag.ul("a"["b"], clazz = "clazz", init = blockUl::invoke)

        verificationWithClass(ul, blockUl)
    }

    @Test
    fun `ul function works without class`() {
        val tag = BodyTagContainer("tag")
        every { blockUl.invoke(any()) }.returns(Unit)

        val ul = tag.ul("a"["b"], init = blockUl::invoke)

        verificationWithoutClass(ul, blockUl)
    }

    @Test
    fun `ol function works`() {
        val tag = BodyTagContainer("tag")
        every { blockOl.invoke(any()) }.returns(Unit)

        val ol = tag.ol("a"["b"], clazz = "clazz", init = blockOl::invoke)

        verificationWithClass(ol, blockOl)
    }

    @Test
    fun `ol function works without class`() {
        val tag = BodyTagContainer("tag")
        every { blockOl.invoke(any()) }.returns(Unit)

        val ol = tag.ol("a"["b"], init = blockOl::invoke)

        verificationWithoutClass(ol, blockOl)
    }

    @Test
    fun `menu function works`() {
        val tag = BodyTagContainer("tag")
        every { blockMenu.invoke(any()) }.returns(Unit)

        val menu = tag.menu("a"["b"], clazz = "clazz", init = blockMenu::invoke)

        verificationWithClass(menu, blockMenu)
    }

    @Test
    fun `menu function works without class`() {
        val tag = BodyTagContainer("tag")
        every { blockMenu.invoke(any()) }.returns(Unit)

        val menu = tag.menu("a"["b"], init = blockMenu::invoke)

        verificationWithoutClass(menu, blockMenu)
    }

    @Test
    fun `dl function works`() {
        val tag = BodyTagContainer("tag")
        every { blockDl.invoke(any()) }.returns(Unit)

        val dl = tag.dl("a"["b"], clazz = "clazz", init = blockDl::invoke)

        verificationWithClass(dl, blockDl)
    }

    @Test
    fun `dl function works without class`() {
        val tag = BodyTagContainer("tag")
        every { blockDl.invoke(any()) }.returns(Unit)

        val dl = tag.dl("a"["b"], init = blockDl::invoke)

        verificationWithoutClass(dl, blockDl)
    }

    @Test
    fun `details function works`() {
        val tag = BodyTagContainer("tag")
        every { blockDetails.invoke(any()) }.returns(Unit)

        val details = tag.details(true, init = blockDetails::invoke)

        verificationWithClass(details, blockDetails, mapOf(
            "open" to listOf(null)
        ))
    }

    @Test
    fun `details function works when not opened`() {
        val tag = BodyTagContainer("tag")
        every { blockDetails.invoke(any()) }.returns(Unit)

        val details = tag.details(false, init = blockDetails::invoke)

        verificationWithClass(details, blockDetails, mapOf())
    }

    @Test
    fun `a function works`() {
        val tag = BodyTagContainer("tag")
        every { blockA.invoke(any()) }.returns(Unit)

        val a = tag.a("a"["b"], href = "link", clazz = "clazz", init = blockA::invoke)

        verificationWithClass(a, blockA, mapOf(
            "a" to listOf("b"),
            "href" to listOf("link"),
            "class" to listOf("clazz"),
        ))
    }

    @Test
    fun `a function works without class`() {
        val tag = BodyTagContainer("tag")
        every { blockA.invoke(any()) }.returns(Unit)

        val a = tag.a(href = "link", init = blockA::invoke)

        verificationWithoutClass(a, blockA, mapOf(
            "href" to listOf("link"),
        ))
    }

    @Test
    fun `a function works with all attributes`() {
        val tag = BodyTagContainer("tag")
        every { blockA.invoke(any()) }.returns(Unit)

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
            init = blockA::invoke
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
        every { blockA.invoke(any()) }.returns(Unit)

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
            init = blockA::invoke
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
    fun `form function works`() {
        val tag = BodyTagContainer("tag")
        every { blockForm.invoke(any()) }.returns(Unit)

        val form = tag.form("a"["b"], action = "action1", name = "name1", method = Method.POST, clazz = "clazz", id="id1", init = blockForm::invoke)

        verificationWithClass(form, blockForm, mapOf(
            "a" to listOf("b"),
            "action" to listOf("action1"),
            "name" to listOf("name1"),
            "method" to listOf("post"),
            "class" to listOf("clazz"),
            "id" to listOf("id1"),
        ))
    }

    @Test
    fun `form function works without class`() {
        val tag = BodyTagContainer("tag")
        every { blockForm.invoke(any()) }.returns(Unit)

        val form = tag.form("a"["b"], action = "action1", name = "name1", method = Method.POST, id="id1", init = blockForm::invoke)

        verificationWithoutClass(form, blockForm, mapOf(
            "a" to listOf("b"),
            "action" to listOf("action1"),
            "name" to listOf("name1"),
            "method" to listOf("post"),
            "id" to listOf("id1"),
        ))
    }

    @Test
    fun `form function works with all attributes`() {
        val tag = BodyTagContainer("tag")
        every { blockForm.invoke(any()) }.returns(Unit)

        val form = tag.form(
            "a"["b"],
            acceptCharset = "UTF-8",
            clazz = "clazz",
            action = "action1",
            autoComplete = AutoComplete.OFF,
            encType = EncType.Application_x_www_form_urlencoded,
            method = Method.POST,
            name = "name1",
            noValidate = true,
            rel = Rel.TAG,
            target = Target.SELF,
            id = "id1",
            init = blockForm::invoke
        )

        verificationWithClass(form, blockForm, mapOf(
            "a" to listOf("b"),
            "accept-charset" to listOf("UTF-8"),
            "action" to listOf("action1"),
            "autocomplete" to listOf(AutoComplete.OFF.value),
            "enctype" to listOf(EncType.Application_x_www_form_urlencoded.value),
            "method" to listOf(Method.POST.value),
            "name" to listOf("name1"),
            "novalidate" to listOf(null),
            "rel" to listOf(Rel.TAG.value),
            "target" to listOf(Target.SELF.value),
            "class" to listOf("clazz"),
            "id" to listOf("id1"),
        ))
    }

    @Test
    fun `form function works with all attributes if some are null`() {
        val tag = BodyTagContainer("tag")
        every { blockForm.invoke(any()) }.returns(Unit)

        val form = tag.form(
            "a"["b"],
            acceptCharset = "UTF-8",
            clazz = "clazz",
            action = "action1",
            autoComplete = AutoComplete.OFF,
            encType = EncType.Application_x_www_form_urlencoded,
            method = Method.POST,
            name = "name1",
            noValidate = true,
            rel = null, //<--
            target = null, //<--
            id = "id1",
            init = blockForm::invoke
        )

        verificationWithClass(form, blockForm, mapOf(
            "a" to listOf("b"),
            "accept-charset" to listOf("UTF-8"),
            "action" to listOf("action1"),
            "autocomplete" to listOf(AutoComplete.OFF.value),
            "enctype" to listOf(EncType.Application_x_www_form_urlencoded.value),
            "method" to listOf(Method.POST.value),
            "name" to listOf("name1"),
            "novalidate" to listOf(null),
            //"rel" to listOf(null),
            //"target" to listOf(null),
            "class" to listOf("clazz"),
            "id" to listOf("id1"),
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
        callable: Fun1<Tag, Unit>,
        expectedMap: Map<String, List<String?>> = mapOf(
            "a" to listOf("b"),
            "class" to listOf("clazz"),
        )
    ) {
        verify { callable.invoke(tag) }
            .wasInvoked(exactly = once)

        expectedMap.forEach { (key, value) ->
            assertEquals(value, tag.attributes[key], key)
        }
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

        expectedMap.forEach { (key, value) ->
            assertEquals(value, tag.attributes[key], key)
        }
    }
}
