package example

import lib.base.Element
import lib.*

val page1: Element =
    html(lang="en") {
        head {
            title {
                +"My Webpage"
            }
            meta("viewport", "width=device-width, initial-scale=1")
        }
        body {
            h1 {
                +"Hello, world!"
            }
            !"more comments"
            hr()
            div(clazz["MyClass"], clazz["MyClass2"]) {
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
