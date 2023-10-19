package lib.base

import lib.Context
import lib.visitors.DebugVisitor
import lib.visitors.ProductionVisitor

interface Visitor {
    val html: String

    fun visitTextElement(element: TextElement)
    fun visitTag(tag: Tag)
    fun visitComment(comment: Comment)
    fun visitTagWithAttributes(tag: TagWithAttributes)
    fun visitTagContainerBegin(tagContainer: TagContainer)
    fun visitTagContainerEnd(tagContainer: TagContainer)
}

fun interface VisitorFactory {
    fun create(): Visitor
}

val productionContext: Context = Context { ProductionVisitor() }
val debugContext: Context = Context { DebugVisitor() }
