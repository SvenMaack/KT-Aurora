package lib

import lib.base.TagContainer

class Body: TagContainer("body") {
    inline fun p(init: P.() -> Unit) = add(P(), init)
    inline fun h1(init: H1.() -> Unit) = add(H1(), init)
    inline fun h2(init: H2.() -> Unit) = add(H2(), init)
    inline fun h3(init: H3.() -> Unit) = add(H3(), init)
    inline fun h4(init: H4.() -> Unit) = add(H4(), init)
    inline fun h5(init: H5.() -> Unit) = add(H5(), init)
    inline fun h6(init: H6.() -> Unit) = add(H6(), init)
    inline fun br() = add(Br()) {}
}