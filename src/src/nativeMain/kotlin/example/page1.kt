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
 *         <title>
 *             My web page
 *         </title>
 *     </head>
 *     <body>
 *         <h1>
 *             Hello, world!
 *         </h1>
 *         <p class="myClass">
 *             This is my first web page.
 *         </p>
 *     </body>
 * </html>
 */