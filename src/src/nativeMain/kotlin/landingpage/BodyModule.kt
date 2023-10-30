package landingpage

import template_lib.StaticTemplate
import template_lib.include
import template_lib.tags.Body

val BodyModule: StaticTemplate = { context ->
    Body().apply {
        include(template=Navigation, context=context)
        hr()
        div(clazz="MyClass") {
            p(clazz="test") {
                +"This is my first kotlin rendered page"
            }
        }
    }
}
