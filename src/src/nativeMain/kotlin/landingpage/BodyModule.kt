package landingpage

import modules_lib.navigation.NavigationDto
import modules_lib.navigation.NavigationTemplate
import template_lib.DynamicTemplate
import template_lib.StaticTemplate
import template_lib.childs
import template_lib.include
import template_lib.tags.Body

val BodyModule: DynamicTemplate<NavigationDto> = { context, data ->
    Body().apply {
        include(template=DynamicBody, context=context, dto=data)
        include(template=StaticBody, context=context)
    }
}


val DynamicBody: DynamicTemplate<NavigationDto> = { context, data ->
    Body().childs {
        include(template=NavigationTemplate, context=context, dto=data)
    }
}

val StaticBody: StaticTemplate = { _ ->
    Body().childs {
        hr()
        div(clazz="MyClass") {
            p(clazz="test") {
                +"This is my first kotlin rendered page"
            }
        }
    }
}