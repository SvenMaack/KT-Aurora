package template_lib.visitors

import template_lib.base.AttributeWithValueImpl
import template_lib.base.Comment
import template_lib.base.TagContainer
import template_lib.base.TagWithAttributes
import kotlin.test.Test
import kotlin.test.assertEquals

class ProductionVisitorTest {
    @Test
    fun `visit tag prints tag`() {
        val tagWithAttributes = TagWithAttributes("a")
        val productionVisitor = ProductionHtmlVisitor()

        productionVisitor.visitTagWithAttributes(tagWithAttributes)

        assertEquals("<a>", productionVisitor.result)
    }

    @Test
    fun `visit comment prints not comment`() {
        val comment = Comment("comment")
        val productionVisitor = ProductionHtmlVisitor()

        productionVisitor.visitComment(comment)

        assertEquals("", productionVisitor.result)
    }

    @Test
    fun `visit tag container begin prints open tag`() {
        val tagContainer = TagContainer("a")
        val productionVisitor = ProductionHtmlVisitor()

        productionVisitor.visitTagContainerBegin(tagContainer)

        assertEquals("<a>", productionVisitor.result)
    }

    @Test
    fun `visit tag container end prints close tag`() {
        val tagContainer = TagContainer("a")
        val productionVisitor = ProductionHtmlVisitor()

        productionVisitor.visitTagContainerEnd(tagContainer)

        assertEquals("</a>", productionVisitor.result)
    }

    @Test
    fun `attributes are printed in tagContainer`() {
        val tagContainer = TagContainer("a")
        tagContainer.setAttributes(
            AttributeWithValueImpl("same", "a"),
            AttributeWithValueImpl("same", "b"),
            AttributeWithValueImpl("other", "c")
        )

        val productionVisitor = ProductionHtmlVisitor()
        productionVisitor.visitTagContainerBegin(tagContainer)
        productionVisitor.visitTagContainerEnd(tagContainer)

        assertEquals("<a same=\"a b\" other=\"c\"></a>", productionVisitor.result)
    }

    @Test
    fun `attributes are printed in tag`() {
        val tagWithAttributes = TagWithAttributes("a").setAttributes(
            AttributeWithValueImpl("same", "a"),
            AttributeWithValueImpl("same", "b"),
            AttributeWithValueImpl("other", "c")
        )

        val productionVisitor = ProductionHtmlVisitor()
        productionVisitor.visitTagWithAttributes(tagWithAttributes)

        assertEquals("<a same=\"a b\" other=\"c\">", productionVisitor.result)
    }

    @Test
    fun `empty attributes doesn't change the tag`() {
        val tagWithAttributes = TagWithAttributes("a").setAttributes()

        val productionVisitor = ProductionHtmlVisitor()
        productionVisitor.visitTagWithAttributes(tagWithAttributes)

        assertEquals("<a>", productionVisitor.result)
    }

    @Test
    fun `empty attributes doesn't change the tagContainer`() {
        val tagContainer = TagContainer("a")
        tagContainer.setAttributes()

        val productionVisitor = ProductionHtmlVisitor()
        productionVisitor.visitTagContainerBegin(tagContainer)
        productionVisitor.visitTagContainerEnd(tagContainer)

        assertEquals("<a></a>", productionVisitor.result)
    }

    @Test
    fun `allow attributes without value in the tag`() {
        val tagWithAttributes = TagWithAttributes("a").setAttributes(
            AttributeWithValueImpl("attr", ""),
            AttributeWithValueImpl("attr2", "value")
        )

        val productionVisitor = ProductionHtmlVisitor()
        productionVisitor.visitTagWithAttributes(tagWithAttributes)

        assertEquals("<a attr attr2=\"value\">", productionVisitor.result)
    }

    @Test
    fun `allow attributes without value in the tagContainer`() {
        val tagContainer = TagContainer("a")
        tagContainer.setAttributes(
            AttributeWithValueImpl("attr", ""),
            AttributeWithValueImpl("attr2", "value")
        )

        val productionVisitor = ProductionHtmlVisitor()
        productionVisitor.visitTagContainerBegin(tagContainer)
        productionVisitor.visitTagContainerEnd(tagContainer)

        assertEquals("<a attr attr2=\"value\"></a>", productionVisitor.result)
    }

    @Test
    fun `indentation is not added`() {
        val tagContainer = TagContainer("a")
        val productionVisitor = ProductionHtmlVisitor()

        productionVisitor.visitTagContainerBegin(tagContainer)
        productionVisitor.visitTagContainerBegin(tagContainer)
        productionVisitor.visitTagContainerEnd(tagContainer)
        productionVisitor.visitTagContainerEnd(tagContainer)

        assertEquals("<a><a></a></a>", productionVisitor.result)
    }
}