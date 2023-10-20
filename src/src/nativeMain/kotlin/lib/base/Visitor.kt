package lib.base

import lib.Context
import lib.visitors.DebugVisitor
import lib.visitors.ProductionVisitor

interface Visitor<T> {
    val result: T

    fun visitTextElement(element: TextElement)
    fun visitTag(tag: Tag)
    fun visitComment(comment: Comment)
    fun visitTagWithAttributes(tag: TagWithAttributes)
    fun visitTagContainerBegin(tagContainer: TagContainer)
    fun visitTagContainerEnd(tagContainer: TagContainer)
}

fun interface VisitorFactory<T> {
    fun create(): Visitor<T>
}

val productionContext: Context = Context { ProductionVisitor() }
val debugContext: Context = Context { DebugVisitor() }
