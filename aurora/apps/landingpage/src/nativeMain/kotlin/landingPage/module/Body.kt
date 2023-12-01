package landingPage.module

import modules_lib.navigation.NavigationVM
import modules_lib.navigation.NavigationModule
import template_lib.Template
import template_lib.StaticTemplate
import template_lib.childs
import template_lib.include
import template_lib.tags.Body

val BodyTemplate: Template<NavigationVM> = { context, data ->
    Body().apply {
        include(template=DynamicBody, context=context, dto=data)
        include(template=StaticBody,  context=context)
    }
}

private val DynamicBody: Template<NavigationVM> = { context, data ->
    Body().apply {
        include(template = NavigationModule.template, context = context, dto = data)
    }.childs()
}

private val StaticBody: StaticTemplate = { _, _ ->
    Body().apply {
        div(clazz = "MyClass") {
            p(clazz = "test") {
                +"This is my first kotlin rendered page"
            }
        }
    }.childs()
}
