package landingpage

import template_lib.StaticTemplate
import template_lib.childs
import template_lib.tags.Div

val Navigation: StaticTemplate = { _ ->
    Div().childs {
        nav(clazz="navigation") {
            ul {
                li{
                    span{+"Home"}
                }
                li{
                    span{+"Trends"}
                }
                li{
                    span{+"Sales"}
                }
            }
        }
    }
}
