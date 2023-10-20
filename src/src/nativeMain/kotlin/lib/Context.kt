package lib

import lib.base.VisitorFactory

data class Context(
    val visitorFactory: VisitorFactory<String>
)
