package lib.visitors

import lib.base.Attribute
import lib.base.Comment
import lib.base.TagContainer
import lib.base.TagWithAttributes
import lib.visitors.ProductionVisitor
import kotlin.test.Test
import kotlin.test.assertEquals

class ProductionVisitorTest {
    @Test
    fun `visit tag prints tag`() {
        val tagWithAttributes = TagWithAttributes("a")
        val productionVisitor = ProductionVisitor()

        productionVisitor.visitTagWithAttributes(tagWithAttributes)

        assertEquals("<a>", productionVisitor.result)
    }

    @Test
    fun `visit comment prints not comment`() {
        val comment = Comment("comment")
        val productionVisitor = ProductionVisitor()

        productionVisitor.visitComment(comment)

        assertEquals("", productionVisitor.result)
    }

    @Test
    fun `visit tag container begin prints open tag`() {
        val tagContainer = TagContainer("a")
        val productionVisitor = ProductionVisitor()

        productionVisitor.visitTagContainerBegin(tagContainer)

        assertEquals("<a>", productionVisitor.result)
    }

    @Test
    fun `visit tag container end prints close tag`() {
        val tagContainer = TagContainer("a")
        val productionVisitor = ProductionVisitor()

        productionVisitor.visitTagContainerEnd(tagContainer)

        assertEquals("</a>", productionVisitor.result)
    }

    @Test
    fun `attributes are printed in tagContainer`() {
        val tagContainer = TagContainer("a")
        tagContainer.setAttributes(object : Attribute {
            override val name: String = "same"
            override val value: String = "a"
        },object : Attribute {
            override val name: String = "same"
            override val value: String = "b"
        },object : Attribute {
            override val name: String = "other"
            override val value: String = "c"
        })

        val productionVisitor = ProductionVisitor()
        productionVisitor.visitTagContainerBegin(tagContainer)
        productionVisitor.visitTagContainerEnd(tagContainer)

        assertEquals("<a same=\"a b\" other=\"c\"></a>", productionVisitor.result)
    }

    @Test
    fun `attributes are printed in tag`() {
        val tagWithAttributes = TagWithAttributes("a").setAttributes(object : Attribute {
            override val name: String = "same"
            override val value: String = "a"
        },object : Attribute {
            override val name: String = "same"
            override val value: String = "b"
        },object : Attribute {
            override val name: String = "other"
            override val value: String = "c"
        })

        val productionVisitor = ProductionVisitor()
        productionVisitor.visitTagWithAttributes(tagWithAttributes)

        assertEquals("<a same=\"a b\" other=\"c\">", productionVisitor.result)
    }

    @Test
    fun `empty attributes doesn't change the tag`() {
        val tagWithAttributes = TagWithAttributes("a").setAttributes()

        val productionVisitor = ProductionVisitor()
        productionVisitor.visitTagWithAttributes(tagWithAttributes)

        assertEquals("<a>", productionVisitor.result)
    }

    @Test
    fun `empty attributes doesn't change the tagContainer`() {
        val tagContainer = TagContainer("a")
        tagContainer.setAttributes()

        val productionVisitor = ProductionVisitor()
        productionVisitor.visitTagContainerBegin(tagContainer)
        productionVisitor.visitTagContainerEnd(tagContainer)

        assertEquals("<a></a>", productionVisitor.result)
    }

    @Test
    fun `allow attributes without value in the tag`() {
        val tagWithAttributes = TagWithAttributes("a").setAttributes(
            object : Attribute {
                override val name: String = "attr"
                override val value: String = ""
            },
            object : Attribute {
                override val name: String = "attr2"
                override val value: String = "value"
            }
        )

        val productionVisitor = ProductionVisitor()
        productionVisitor.visitTagWithAttributes(tagWithAttributes)

        assertEquals("<a attr attr2=\"value\">", productionVisitor.result)
    }

    @Test
    fun `allow attributes without value in the tagContainer`() {
        val tagContainer = TagContainer("a")
        tagContainer.setAttributes(
            object : Attribute {
                override val name: String = "attr"
                override val value: String = ""
            },
            object : Attribute {
                override val name: String = "attr2"
                override val value: String = "value"
            }
        )

        val productionVisitor = ProductionVisitor()
        productionVisitor.visitTagContainerBegin(tagContainer)
        productionVisitor.visitTagContainerEnd(tagContainer)

        assertEquals("<a attr attr2=\"value\"></a>", productionVisitor.result)
    }

    @Test
    fun `indentation is not added`() {
        val tagContainer = TagContainer("a")
        val productionVisitor = ProductionVisitor()

        productionVisitor.visitTagContainerBegin(tagContainer)
        productionVisitor.visitTagContainerBegin(tagContainer)
        productionVisitor.visitTagContainerEnd(tagContainer)
        productionVisitor.visitTagContainerEnd(tagContainer)

        assertEquals("<a><a></a></a>", productionVisitor.result)
    }
}