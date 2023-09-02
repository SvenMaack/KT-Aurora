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
            p {
                +"This is my first web page."
            }
            br()
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
 *         </br>
 *     </body>
 * </html>
 */