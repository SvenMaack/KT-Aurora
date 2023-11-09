package page_lib.styling

import css_lib.base.Document
import css_lib.base.Property
import template_lib.base.Attribute
import template_lib.base.Element
import template_lib.base.TagContainer
import kotlin.test.Test
import kotlin.test.assertEquals

class RemoveUnusedSelectorsTest {
    @Test
    fun `test remove of unused works`() {
        val document = Document().apply {
            this["s1"] = {
                +Property.build("p1", "v1")
            }
            this["s2"] = {
                +Property.build("p2", "v2")
            }
        }
        val element: Element = TagContainer("test").apply {
            setAttributes(object : Attribute {
                override val name: String = "class"
                override val value: String = "s1"
            })
        }

        val updatedDocument = RemoveUnusedSelectors(element).rig(document) as Document

        assertEquals(2, document.getRuleAmount())
        assertEquals(1, updatedDocument.getRuleAmount())
    }
}