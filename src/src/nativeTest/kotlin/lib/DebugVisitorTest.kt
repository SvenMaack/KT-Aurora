package lib

import lib.base.Attribute
import lib.base.TagContainer
import lib.base.TagWithAttributes
import kotlin.test.Test
import kotlin.test.assertEquals

@Suppress("FunctionNaming")
class DebugVisitorTest {
    @Test
    fun `visit tag prints tag`() {
        val tagWithAttributes = TagWithAttributes("a")
        val debugVisitor = DebugVisitor()

        debugVisitor.visitTagWithAttributes(tagWithAttributes)

        assertEquals("<a>${DebugVisitor.linebreak}", debugVisitor.html)
    }

    @Test
    fun `visit tag container begin prints open tag`() {
        val tagContainer = TagContainer("a")
        val debugVisitor = DebugVisitor()

        debugVisitor.visitTagContainerBegin(tagContainer)

        assertEquals("<a>${DebugVisitor.linebreak}", debugVisitor.html)
    }

    @Test
    fun `visit tag container end prints close tag`() {
        val tagContainer = TagContainer("a")
        val debugVisitor = DebugVisitor()

        debugVisitor.visitTagContainerEnd(tagContainer)

        assertEquals("</a>${DebugVisitor.linebreak}", debugVisitor.html)
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

        val debugVisitor = DebugVisitor()
        debugVisitor.visitTagContainerBegin(tagContainer)
        debugVisitor.visitTagContainerEnd(tagContainer)

        assertEquals("<a same=\"a b\" other=\"c\">${DebugVisitor.linebreak}</a>${DebugVisitor.linebreak}", debugVisitor.html)
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

        val debugVisitor = DebugVisitor()
        debugVisitor.visitTagWithAttributes(tagWithAttributes)

        assertEquals("<a same=\"a b\" other=\"c\">${DebugVisitor.linebreak}", debugVisitor.html)
    }

    @Test
    fun `empty attributes doesn't change the tag`() {
        val tagWithAttributes = TagWithAttributes("a").setAttributes()

        val debugVisitor = DebugVisitor()
        debugVisitor.visitTagWithAttributes(tagWithAttributes)

        assertEquals("<a>${DebugVisitor.linebreak}", debugVisitor.html)
    }

    @Test
    fun `empty attributes doesn't change the tagContainer`() {
        val tagContainer = TagContainer("a")
        tagContainer.setAttributes()

        val debugVisitor = DebugVisitor()
        debugVisitor.visitTagContainerBegin(tagContainer)
        debugVisitor.visitTagContainerEnd(tagContainer)

        assertEquals("<a>${DebugVisitor.linebreak}</a>${DebugVisitor.linebreak}", debugVisitor.html)
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
            "<a>${DebugVisitor.linebreak}${DebugVisitor.indentation}<a>${DebugVisitor.linebreak}${DebugVisitor.indentation}</a>${DebugVisitor.linebreak}</a>${DebugVisitor.linebreak}",
            debugVisitor.html
        )
    }
}