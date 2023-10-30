package example

import template_lib.StaticTemplate
import template_lib.tags.Div

val Navigation: StaticTemplate = { _ ->
    Div().apply {
        div(clazz="navigation") {
            span{
                +"Home"
            }
            span{
                +"Trends"
            }
            span{
                +"Sales"
            }
        }
    }
}