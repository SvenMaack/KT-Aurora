package lib

import lib.tags.base.Visitor

fun interface VisitorFactory {
    fun getVisitor(): Visitor
}

data class Context(
    val visitorFactory: VisitorFactory
)
