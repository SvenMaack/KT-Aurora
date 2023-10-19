package lib

import lib.tags.base.Visitor

fun interface VisitorFactory {
    fun create(): Visitor
}

data class Context(
    val visitorFactory: VisitorFactory
)
