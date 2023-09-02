package example

import lib.base.Element
import lib.html

val page1: Element =
    html {
        head {
        }
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


/**
 * <!DOCTYPE html>
 * <html>
 *     <head>
 *         <title>My web page</title>
 *     </head>
 *     <body>
 *         <h1>Hello, world!</h1>
 *         <p>This is my first web page.</p>
 *     </body>
 * </html>
 */