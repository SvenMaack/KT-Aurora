package example

import css_lib.base.Document
import css_lib.properties.margin
import css_lib.properties.`margin-right`
import css_lib.properties.px
import css_lib.visitors.DebugVisitor

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
