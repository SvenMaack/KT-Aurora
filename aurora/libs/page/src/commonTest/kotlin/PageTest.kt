import css_lib.base.Document
import page_lib.Page
import template_lib.base.TagContainer
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertSame

class PageTest {
    @Test
    fun `add Document`() {
        val page = Page<String>({_,_ -> TagContainer("tag") }, Document())
        val document = Document()

        page.addDocument(document)

        assertEquals(2, page._cssDocument.getDocumentSize())
        assertSame(document, page._cssDocument.getDocument(1))
    }
}
