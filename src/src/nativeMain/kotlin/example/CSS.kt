package example

import css_lib.*
import css_lib.px

val document: Document = Document().apply {
    this[".logo"] = {
        `margin-right`(5.px)
        margin(50.px)
    }

    this[".myClass2", ".myClass3"] = {
        `margin-right`(5.px)
        margin(50.px)
    }
}

val visitor = DebugVisitor()
val cssRules: Lazy<String> = lazy {
    document.traverse(visitor)
    visitor.result
}
