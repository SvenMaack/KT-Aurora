package example

import lib.StaticTemplate
import lib.include
import lib.tags.Body

val BodyModule: StaticTemplate = { context ->
    Body().apply {
        include(template=Header, context=context)
        div(clazz="image") {
            span {
                +"image"
            }
        }
        hr()
        div(clazz="MyClass") {
            p(clazz="test") {
                +"This is my first"
            }
            span {
                +"kotlin rendered page"
            }
        }
    }
}
