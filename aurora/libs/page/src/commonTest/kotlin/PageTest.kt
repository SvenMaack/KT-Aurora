import css_lib.base.Document
import css_lib.base.Property
import css_lib.base.browser.Chrome
import css_lib.properties.margin
import css_lib.properties.px
import css_lib.visitors.ProductionVisitor
import page_lib.Page
import template_lib.base.TagContainer
import kotlin.test.Test
import kotlin.test.assertEquals

class PageTest {
    @Test
    fun `add Document`() {
        val page = Page<String>(
            "test",
            {_,_ -> TagContainer("tag") },
            { ProductionVisitor() }
        )
        val document = Document()

        page.apply {
            +document
        }

        assertEquals(1, page.cssDocument.getDocumentAmount())
    }
}
