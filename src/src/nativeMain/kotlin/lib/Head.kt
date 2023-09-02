package lib

import lib.base.TagContainer

class Head: TagContainer("head") {
    inline fun title(init: Title.() -> Unit) = add(Title(), init)
}