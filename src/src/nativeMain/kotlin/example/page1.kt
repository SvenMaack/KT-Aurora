package example

import lib.base.Element
import lib.*

val page1: Element =
    html {
        head {
            title {
                +"My Webpage"
            }
        }
        body {
            h1 {
                +"Hello, world!"
            }
            div(clazz["MyClass"], clazz["MyClass2"]) {
                p(clazz="test") {
                    +"This is my first web page."
                }
            }
            br()
        }
    }
