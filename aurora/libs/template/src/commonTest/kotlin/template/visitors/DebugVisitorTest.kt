package template.visitors

import template.base.AttributeImpl
import template.base.AttributeWithValueImpl
import template.base.Comment
import template.base.TagContainer
import template.base.TagWithAttributes
import kotlin.test.Test
import kotlin.test.assertEquals

class DebugVisitorTest {
    @Test
    fun `visit tag prints tag`() {
        val tagWithAttributes = TagWithAttributes("a")
        val debugVisitor = DebugHtmlVisitor()

        debugVisitor.visitTagWithAttributes(tagWithAttributes)

        assertEquals("<a>${DebugHtmlVisitor.LINE_BREAK}", debugVisitor.result)
    }

    @Test
    fun `visit comment prints comment`() {
        val comment = Comment("comment")
        val debugVisitor = DebugHtmlVisitor()

        debugVisitor.visitComment(comment)

        assertEquals("<!--comment-->${DebugHtmlVisitor.LINE_BREAK}", debugVisitor.result)
    }

    @Test
    fun `visit tag container begin prints open tag`() {
        val tagContainer = TagContainer("a")
        val debugVisitor = DebugHtmlVisitor()

        debugVisitor.visitTagContainerBegin(tagContainer)

        assertEquals("<a>${DebugHtmlVisitor.LINE_BREAK}", debugVisitor.result)
    }

    @Test
    fun `visit tag container end prints close tag`() {
        val tagContainer = TagContainer("a")
        val debugVisitor = DebugHtmlVisitor()

        debugVisitor.visitTagContainerEnd(tagContainer)

        assertEquals("</a>${DebugHtmlVisitor.LINE_BREAK}", debugVisitor.result)
    }

    @Test
    fun `attributes are printed in tagContainer`() {
        val tagContainer = TagContainer("a")
        tagContainer.setAttributes(
            AttributeWithValueImpl("same", "a"),
            AttributeWithValueImpl("same", "b"),
            AttributeWithValueImpl("other", "c")
        )

        val debugVisitor = DebugHtmlVisitor()
        debugVisitor.visitTagContainerBegin(tagContainer)
        debugVisitor.visitTagContainerEnd(tagContainer)

        assertEquals("<a same=\"a b\" other=\"c\">${DebugHtmlVisitor.LINE_BREAK}</a>${DebugHtmlVisitor.LINE_BREAK}", debugVisitor.result)
    }

    @Test
    fun `attributes are printed in tagWithAttributes`() {
        val tagWithAttributes = TagWithAttributes("a").setAttributes(
            AttributeWithValueImpl("same", "a"),
            AttributeWithValueImpl("same", "b"),
            AttributeWithValueImpl("other", "c")
        )

        val debugVisitor = DebugHtmlVisitor()
        debugVisitor.visitTagWithAttributes(tagWithAttributes)

        assertEquals("<a same=\"a b\" other=\"c\">${DebugHtmlVisitor.LINE_BREAK}", debugVisitor.result)
    }

    @Test
    fun `attribute mix is printed in tagWithAttributes`() {
        val tagWithAttributes = TagWithAttributes("a").setAttributes(
            AttributeWithValueImpl("same", "a"),
            AttributeImpl("same"),
            AttributeWithValueImpl("other", "c")
        )

        val debugVisitor = DebugHtmlVisitor()
        debugVisitor.visitTagWithAttributes(tagWithAttributes)

        assertEquals("<a same=\"a\" other=\"c\">${DebugHtmlVisitor.LINE_BREAK}", debugVisitor.result)
    }

    @Test
    fun `empty attributes doesn't change the tag`() {
        val tagWithAttributes = TagWithAttributes("a").setAttributes()

        val debugVisitor = DebugHtmlVisitor()
        debugVisitor.visitTagWithAttributes(tagWithAttributes)

        assertEquals("<a>${DebugHtmlVisitor.LINE_BREAK}", debugVisitor.result)
    }

    @Test
    fun `empty attributes doesn't change the tagContainer`() {
        val tagContainer = TagContainer("a")
        tagContainer.setAttributes()

        val debugVisitor = DebugHtmlVisitor()
        debugVisitor.visitTagContainerBegin(tagContainer)
        debugVisitor.visitTagContainerEnd(tagContainer)

        assertEquals("<a>${DebugHtmlVisitor.LINE_BREAK}</a>${DebugHtmlVisitor.LINE_BREAK}", debugVisitor.result)
    }

    @Test
    fun `allow attributes without value in the tag`() {
        val tagWithAttributes = TagWithAttributes("a").setAttributes(
            AttributeWithValueImpl("attr", ""),
            AttributeWithValueImpl("attr2", "value")
        )

        val debugVisitor = DebugHtmlVisitor()
        debugVisitor.visitTagWithAttributes(tagWithAttributes)

        assertEquals("<a attr attr2=\"value\">${DebugHtmlVisitor.LINE_BREAK}", debugVisitor.result)
    }

    @Test
    fun `allow attributes without value in the tagContainer`() {
        val tagContainer = TagContainer("a")
        tagContainer.setAttributes(
            AttributeWithValueImpl("attr", ""),
            AttributeWithValueImpl("attr2", "value")
        )

        val debugVisitor = DebugHtmlVisitor()
        debugVisitor.visitTagContainerBegin(tagContainer)
        debugVisitor.visitTagContainerEnd(tagContainer)

        assertEquals("<a attr attr2=\"value\">${DebugHtmlVisitor.LINE_BREAK}</a>${DebugHtmlVisitor.LINE_BREAK}", debugVisitor.result)
    }

    @Test
    fun `indentation works`() {
        val tagContainer = TagContainer("a")
        val debugVisitor = DebugHtmlVisitor()

        debugVisitor.visitTagContainerBegin(tagContainer)
        debugVisitor.visitTagContainerBegin(tagContainer)
        debugVisitor.visitTagContainerEnd(tagContainer)
        debugVisitor.visitTagContainerEnd(tagContainer)

        assertEquals(
            "<a>${DebugHtmlVisitor.LINE_BREAK}${DebugHtmlVisitor.INDENTATION}<a>${DebugHtmlVisitor.LINE_BREAK}${DebugHtmlVisitor.INDENTATION}</a>${DebugHtmlVisitor.LINE_BREAK}</a>${DebugHtmlVisitor.LINE_BREAK}",
            debugVisitor.result
        )
    }
}