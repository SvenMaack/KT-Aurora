package landingPage.module

import modules_lib.navigation.NavigationVM
import modules_lib.navigation.NavigationModule
import template.Template
import template.include
import template.tags.Body

val BodyTemplate: Template<NavigationVM> = { context, data ->
    Body().apply {
        include(template=NavigationModule.template, context=context, vm=data)
        include(context=context) {_, _ ->
            main{
                div(clazz = "MyClass") {
                    p(clazz = "test") {
                        +"This is my first kotlin rendered page"
                    }
                }
            }
            footer{
            }
        }
    }
}