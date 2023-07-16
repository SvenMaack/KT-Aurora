package lib

import lib.base.TagContainer

class Html: TagContainer("html") {
    inline fun body(init: Body.() -> Unit) = add(Body(), init)
}

fun html(init: Html.() -> Unit): Html =
    Html().apply(init)
