package lib

import lib.base.Visitor

fun interface VisitorFactory {
    fun create(): Visitor
}

data class Context(
    val visitorFactory: VisitorFactory
)
