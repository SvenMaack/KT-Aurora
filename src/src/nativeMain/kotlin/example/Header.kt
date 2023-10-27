package example

import extensions.images.Loading
import extensions.images.img
import lib.StaticTemplate
import lib.tags.Div

val Header: StaticTemplate = { _ ->
    Div().apply {
        img(src="./logo-big.png", width=250, height=250, alt="Logo", loading=Loading.EAGER)
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