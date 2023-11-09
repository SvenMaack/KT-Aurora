package page_lib

import css_lib.base.Document
import io.mockative.classOf
import io.mockative.mock
import page_lib.styling.Styling
import template_lib.base.TagContainer
import kotlin.test.Test
import kotlin.test.assertEquals

class PageTest {
    @Test
    fun `add Document`() {
        val page = Page<String>(
            "test",
            {_,_ -> TagContainer("tag") },
            {_ -> mock(classOf<Styling>()) }
        )
        val document = Document()

        page.apply {
            +document
        }

        assertEquals(1, page.cssDocument.getDocumentAmount())
    }
}
