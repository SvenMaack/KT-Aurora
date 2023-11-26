package template_lib.visitors

import template_lib.base.AttributeWithValueImpl
import template_lib.base.Comment
import template_lib.base.TagContainer
import template_lib.base.TagWithAttributes
import kotlin.test.Test
import kotlin.test.assertEquals

class DebugVisitorTest {
    @Test
    fun `visit tag prints tag`() {
        val tagWithAttributes = TagWithAttributes("a")
        val debugVisitor = DebugVisitor()

        debugVisitor.visitTagWithAttributes(tagWithAttributes)

        assertEquals("<a>${DebugVisitor.LINE_BREAK}", debugVisitor.result)
    }

    @Test
    fun `visit comment prints comment`() {
        val comment = Comment("comment")
        val debugVisitor = DebugVisitor()

        debugVisitor.visitComment(comment)

        assertEquals("<!--comment-->${DebugVisitor.LINE_BREAK}", debugVisitor.result)
    }

    @Test
    fun `visit tag container begin prints open tag`() {
        val tagContainer = TagContainer("a")
        val debugVisitor = DebugVisitor()

        debugVisitor.visitTagContainerBegin(tagContainer)

        assertEquals("<a>${DebugVisitor.LINE_BREAK}", debugVisitor.result)
    }

    @Test
    fun `visit tag container end prints close tag`() {
        val tagContainer = TagContainer("a")
        val debugVisitor = DebugVisitor()

        debugVisitor.visitTagContainerEnd(tagContainer)

        assertEquals("</a>${DebugVisitor.LINE_BREAK}", debugVisitor.result)
    }

    @Test
    fun `attributes are printed in tagContainer`() {
        val tagContainer = TagContainer("a")
        tagContainer.setAttributes(
            AttributeWithValueImpl("same", "a"),
            AttributeWithValueImpl("same", "b"),
            AttributeWithValueImpl("other", "c")
        )

        val debugVisitor = DebugVisitor()
        debugVisitor.visitTagContainerBegin(tagContainer)
        debugVisitor.visitTagContainerEnd(tagContainer)

        assertEquals("<a same=\"a b\" other=\"c\">${DebugVisitor.LINE_BREAK}</a>${DebugVisitor.LINE_BREAK}", debugVisitor.result)
    }

    @Test
    fun `attributes are printed in tag`() {
        val tagWithAttributes = TagWithAttributes("a").setAttributes(
            AttributeWithValueImpl("same", "a"),
            AttributeWithValueImpl("same", "b"),
            AttributeWithValueImpl("other", "c")
        )

        val debugVisitor = DebugVisitor()
        debugVisitor.visitTagWithAttributes(tagWithAttributes)

        assertEquals("<a same=\"a b\" other=\"c\">${DebugVisitor.LINE_BREAK}", debugVisitor.result)
    }

    @Test
    fun `empty attributes doesn't change the tag`() {
        val tagWithAttributes = TagWithAttributes("a").setAttributes()

        val debugVisitor = DebugVisitor()
        debugVisitor.visitTagWithAttributes(tagWithAttributes)

        assertEquals("<a>${DebugVisitor.LINE_BREAK}", debugVisitor.result)
    }

    @Test
    fun `empty attributes doesn't change the tagContainer`() {
        val tagContainer = TagContainer("a")
        tagContainer.setAttributes()

        val debugVisitor = DebugVisitor()
        debugVisitor.visitTagContainerBegin(tagContainer)
        debugVisitor.visitTagContainerEnd(tagContainer)

        assertEquals("<a>${DebugVisitor.LINE_BREAK}</a>${DebugVisitor.LINE_BREAK}", debugVisitor.result)
    }

    @Test
    fun `allow attributes without value in the tag`() {
        val tagWithAttributes = TagWithAttributes("a").setAttributes(
            AttributeWithValueImpl("attr", ""),
            AttributeWithValueImpl("attr2", "value")
        )

        val debugVisitor = DebugVisitor()
        debugVisitor.visitTagWithAttributes(tagWithAttributes)

        assertEquals("<a attr attr2=\"value\">${DebugVisitor.LINE_BREAK}", debugVisitor.result)
    }

    @Test
    fun `allow attributes without value in the tagContainer`() {
        val tagContainer = TagContainer("a")
        tagContainer.setAttributes(
            AttributeWithValueImpl("attr", ""),
            AttributeWithValueImpl("attr2", "value")
        )

        val debugVisitor = DebugVisitor()
        debugVisitor.visitTagContainerBegin(tagContainer)
        debugVisitor.visitTagContainerEnd(tagContainer)

        assertEquals("<a attr attr2=\"value\">${DebugVisitor.LINE_BREAK}</a>${DebugVisitor.LINE_BREAK}", debugVisitor.result)
    }

    @Test
    fun `indentation works`() {
        val tagContainer = TagContainer("a")
        val debugVisitor = DebugVisitor()

        debugVisitor.visitTagContainerBegin(tagContainer)
        debugVisitor.visitTagContainerBegin(tagContainer)
        debugVisitor.visitTagContainerEnd(tagContainer)
        debugVisitor.visitTagContainerEnd(tagContainer)

        assertEquals(
            "<a>${DebugVisitor.LINE_BREAK}${DebugVisitor.INDENTATION}<a>${DebugVisitor.LINE_BREAK}${DebugVisitor.INDENTATION}</a>${DebugVisitor.LINE_BREAK}</a>${DebugVisitor.LINE_BREAK}",
            debugVisitor.result
        )
    }
}