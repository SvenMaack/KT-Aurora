package example

import lib.base.Element
import lib.html

val page1: Element =
    html {
        body {
            p {
                +"Hello World"
            }
            br()
            p {
                +"Hello Kotlin"
            }
        }
    }
