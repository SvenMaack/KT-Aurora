package landingpage

import css_lib.base.Document
import css_lib.properties.margin
import css_lib.properties.px
import template_lib.StaticTemplate
import template_lib.childs
import template_lib.tags.Div

val Navigation: StaticTemplate = { _ ->
    Div().childs {
        nav(clazz="navigation") {
            ul {
                li(clazz="navigation__item") {
                    span{+"Home"}
                }
                li(clazz="navigation__item") {
                    span{+"Trends"}
                }
                li(clazz="navigation__item") {
                    span{+"Sales"}
                }
            }
        }
    }
}

val navigationCssDocument: Document = Document().apply {
    this[".navigation"] = {
        margin(50.px)
    }
    this[".navigation__item"] = {
        margin(15.px)
    }
}
