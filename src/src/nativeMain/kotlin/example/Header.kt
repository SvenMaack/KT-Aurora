package example

import extensions.images.img
import lib.StaticTemplate
import lib.tags.Div
import lib.with

val Header: StaticTemplate = { _ ->
    Div() with {
        img(src="./logo-big.png", width=250, height=250, alt="Logo")
        div(clazz="navigation") {
            span{
                +"Home"
            }
            span{
                +"Trends"
            }
        }
        div(clazz="menu") {
            span{
                +"search"
            }
        }
    }
}