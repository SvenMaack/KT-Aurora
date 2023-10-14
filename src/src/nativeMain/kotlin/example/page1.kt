package example

import lib.base.Element
import lib.*

val page1: Element =
    html(lang="en") {
        head {
            title {
                +"My Webpage"
            }
            meta(name="viewport", content="width=device-width, initial-scale=1")
            meta(charset="UTF-8")
            meta(name="description", content="Put your description here.")
        }
        body {
            h1 {
                +"Hello, world!"
            }
            !"more comments"
            hr()
            div(clazz="MyClass") {
                p(clazz="test") {
                    +"This is my first"
                }
                span {
                    +"kotlin page"
                }
            }
            br()
        }
    }
