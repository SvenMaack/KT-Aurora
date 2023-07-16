package lib

import lib.base.TagContainer

class Body: TagContainer("body") {
    inline fun p(init: P.() -> Unit) = add(P(), init)
    inline fun br() = add(Br()) {}
}