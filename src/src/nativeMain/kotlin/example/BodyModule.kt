package example

import template_lib.StaticTemplate
import template_lib.include
import template_lib.tags.Body

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
