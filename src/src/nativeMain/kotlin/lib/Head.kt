package lib

import lib.base.TagContainer

class Head: TagContainer("head") {
    inline fun title(init: Title.() -> Unit) = add(Title(), init)

    inline fun meta(
        name: String = "",
        content: String = ""
    ) = add(Meta()) {
        setAttributes("name"[name], "content"[content])
    }
}
