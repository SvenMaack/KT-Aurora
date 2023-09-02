package example

import lib.base.Element
import lib.html

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
            div {
                p {
                    +"This is my first web page."
                }
            }
            br()
        }
    }
